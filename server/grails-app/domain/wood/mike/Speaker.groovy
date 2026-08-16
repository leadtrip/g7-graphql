package wood.mike

import grails.rest.Resource
import grails.util.Holders
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import org.grails.gorm.graphql.entity.dsl.GraphQLMapping
import java.time.LocalDate
import java.time.Period

@Resource(uri='/speaker')
class Speaker {

    String firstName
    String lastName
    String name
    String email
    String bio
    LocalDate birthday

    static hasMany = [talks: Talk]

    static graphql = GraphQLMapping.build {

        property 'lastName', order: 1
        property 'firstName', order: 2
        property 'email', order: 3

        exclude 'birthday'

        property 'name', deprecationReason: 'To be removed August 1st, 2020'

        property('bio') {
            order 4
            dataFetcher { Speaker speaker ->
                speaker.bio ?: "No biography provided"
            }
        }

        add('age', Integer) {
            dataFetcher { Speaker speaker ->
                Period.between(speaker.birthday, LocalDate.now()).years
            }
            input false
        }

        add('mood', String) {
            dataFetcher { Speaker speaker ->
                MoodService moodService = Holders.grailsApplication.mainContext.getBean(MoodService)
                return "${speaker.name} is ${moodService.randomMood}"
            }
        }

        query('speakerByName', Speaker) {
            argument('firstName', String)
            dataFetcher(new DataFetcher() {
                @Override
                Object get(DataFetchingEnvironment environment) {
                    Speaker.findByFirstName(environment.getArgument('firstName'))
                }
            })
        }
    }

    static constraints = {
        email nullable: true, email: true
        birthday nullable: true
        bio nullable: true
    }

    static mapping = {
        bio type: 'text'
        name formula: 'concat(FIRST_NAME,\' \',LAST_NAME)'
        talks sort: 'id'
    }

}