package dogs.infrastructure.http.graphql.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import dogs.application.dogs.ListDogs
import dogs.infrastructure.http.graphql.query.request.DogFilter
import dogs.infrastructure.http.graphql.query.response.Dog
import dogs.infrastructure.http.graphql.query.response.DogResponse

@Component
class DogResolver(val listDogs: ListDogs) : GraphQLQueryResolver {

    fun listDogs(filter: DogFilter): DogResponse {
        println(filter.limit)
        listDogs.list()
        var dogs = listOf(Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")),
                Dog("Toby", 2, "pug", listOf("Activo", "Guapo")))
        return DogResponse(dogs.subList(filter.offset, filter.offset + filter.limit), filter.offset + filter.limit >= dogs.size)
    }
}