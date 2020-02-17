package dogs.application.dogs

import dogs.infrastructure.db.repository.DogRepository
import dogs.infrastructure.http.graphql.query.response.DogResponse
import org.springframework.stereotype.Service

@Service
class ListDogs(val dogRepository: DogRepository) {

    fun list(): DogResponse? {
        var dog = dogRepository.findByName("Toby")
        println(dog.age)
        return null
    }

}