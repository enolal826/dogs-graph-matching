package dogs.infrastructure.http.graphql.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import dogs.application.dogs.ListDogs
import dogs.infrastructure.http.graphql.query.request.ListDogsFilter
import dogs.infrastructure.http.graphql.core.Dog
import dogs.infrastructure.http.graphql.query.request.FindMatchingDogsRequest
import dogs.infrastructure.http.graphql.query.response.ListDogsResponse

@Component
class DogResolver(val listDogs: ListDogs) : GraphQLQueryResolver {

    fun listDogs(filter: ListDogsFilter): ListDogsResponse {
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
        return ListDogsResponse(dogs.subList(filter.offset, filter.offset + filter.limit), filter.offset + filter.limit >= dogs.size)
    }

    fun findMatchingDogs(findMatchingDogsRequest: FindMatchingDogsRequest): List<Dog> {
        return emptyList()
    }
}