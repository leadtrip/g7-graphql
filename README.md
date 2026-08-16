## Grails 7.2.2 app using graphql and react

### Build and run
Bring up the grails app with

`./gradlew server:bootRun`

Hit the graphql API with the supplied [graphql requests](g7-graphql-requests.http)

### Grails graphql documentation
There is/was a stand alone graphql plugin but the functionality seems to have merged into grails core recently 
which is what is used here.
The documentation is not helpful as it's still written as if it's still a plugin.\
No idea how to get the `\graphql\browser` working, have tried adding config `grails.gorm.graphql.browser = true` to no avail.

These sources are kinda useful:
* https://grails.github.io/grails-data-graphql/latest/hibernate/guide/index.html
* https://github.com/apache/grails-core/tree/v7.2.2/grails-data-graphql

### Default queries & mutations
Out of the box you get a bunch of queries and mutations on domain classes with `static graphql = true`,
just use the domain name alone for a get or append one of List, Count, Create, Update or Delete e.g. 
```
book(id:1)
bookList(max:10)
bookCount
bookCreate(book: {})
bookUpdate(id: 1, book: {})
bookDelete(id: 1)
```