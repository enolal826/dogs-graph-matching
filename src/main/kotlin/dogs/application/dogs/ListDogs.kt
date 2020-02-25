package dogs.application.dogs

import dogs.application.dogs.request.ListDogsRequest
import dogs.application.dogs.response.ListDogsResponse
import dogs.infrastructure.db.repository.DogRepository
import org.springframework.stereotype.Service

@Service
class ListDogs(val dogRepository: DogRepository) {
    fun list(listDogsRequest: ListDogsRequest): ListDogsResponse {
        return ListDogsResponse(dogRepository.findAllByOffsetAndLimit(listDogsRequest.offset, listDogsRequest.limit),
                dogRepository.count().toInt())
    }
}