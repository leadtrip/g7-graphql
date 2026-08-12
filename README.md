## Grails 7.2.2 app using graphql and react

Bring up the grails app with

`./gradlew server:bootRun`

Hit the graphql API with the supplied [graphql requests](g7-graphql-requests.http)

There is/was a stand alone graphql plugin but the functionality seems to have merged into grails core recently which is
what is used here, the documentation is not helpful as it's still written as if it's still a plugin.\
No idea how to get the `\graphql\browser` working, have tried adding config `grails.gorm.graphql.browser = true` to no avail.

https://github.com/apache/grails-core/tree/v7.2.2/grails-data-graphql


