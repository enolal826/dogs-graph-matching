package dogs.application.dogs

import dogs.application.dogs.exception.FindMatchingDogsException
import dogs.application.dogs.request.FindMatchingDogsRequest
import dogs.application.dogs.response.FindMatchingDogsResponse
import dogs.domain.exception.DomainException
import dogs.domain.service.MatchingDogsService
import dogs.domain.value_object.HomeTypeAnswer
import dogs.domain.value_object.TimeAtHomeAnswer
import dogs.infrastructure.db.repository.DogRepository
import org.springframework.stereotype.Service

@Service
class FindMatchingDogs(private val matchingDogsService: MatchingDogsService, private val dogRepository: DogRepository) {

    fun find(findMatchingDogsRequest: FindMatchingDogsRequest): FindMatchingDogsResponse {
        val matchingTemperaments = try {
            val homeTypeAnswer = HomeTypeAnswer.Factory.fromExternalString(
                    findMatchingDogsRequest.homeTypeAnswer)
            val timeAtHomeAnswer = TimeAtHomeAnswer.Factory.fromExternalString(
                    findMatchingDogsRequest.timeAtHomeAnswer)

            matchingDogsService.getMatchingTemperaments(homeTypeAnswer, timeAtHomeAnswer)
        } catch (e: DomainException) {
            throw FindMatchingDogsException()
        }

        val matchingDogs = dogRepository.findByTemperaments(matchingTemperaments)
        return FindMatchingDogsResponse(matchingDogs)
    }
}