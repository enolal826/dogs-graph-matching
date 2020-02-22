package dogs.infrastructure.http.graphql.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import dogs.application.dogs.FindMatchingDogs
import org.springframework.stereotype.Component
import dogs.application.dogs.ListDogs
import dogs.application.dogs.request.FindMatchingDogsRequest
import dogs.infrastructure.http.graphql.core.Dog
import dogs.infrastructure.http.graphql.query.input.FindMatchingDogsInput
import dogs.infrastructure.http.graphql.query.input.ListDogsFilterInput
import dogs.infrastructure.http.graphql.query.output.ListDogsOutput

@Component
class DogResolver(val listDogs: ListDogs, val findMatchingDogs: FindMatchingDogs) : GraphQLQueryResolver {

    fun listDogs(filter: ListDogsFilterInput): ListDogsOutput {
        return ListDogsOutput(emptyList(), false)
    }

    fun findMatchingDogs(findMatchingDogsRequest: FindMatchingDogsInput): List<Dog> {
        val response = findMatchingDogs.find(FindMatchingDogsRequest(
                findMatchingDogsRequest.homeType, findMatchingDogsRequest.timeAtHome))

        return response.matchingDogs.map { Dog(it.name, it.age) }.toList()
    }
}