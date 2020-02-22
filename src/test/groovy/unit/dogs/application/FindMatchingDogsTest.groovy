package dogs.application

import dogs.application.dogs.FindMatchingDogs
import dogs.application.dogs.exception.FindMatchingDogsException
import dogs.application.dogs.request.FindMatchingDogsRequest
import dogs.application.request.FindMatchingDogsRequestMother
import dogs.domain.entity.Dog
import dogs.domain.entity.DogMother
import dogs.domain.service.MatchingDogsService
import dogs.domain.value_object.TemperamentValue
import dogs.infrastructure.db.repository.DogRepository
import spock.lang.Specification

class FindMatchingDogsTest extends Specification {

    private FindMatchingDogs findMatchingDogs

    private MatchingDogsService matchingDogsService
    private DogRepository dogRepository

    def setup() {
        this.matchingDogsService = Mock(MatchingDogsService)
        this.dogRepository = Mock(DogRepository)
        this.findMatchingDogs = new FindMatchingDogs(matchingDogsService, dogRepository)
    }

    def "Given a request with valid answers then matching dogs are retrieved"() {
        given:
            def validRequest = FindMatchingDogsRequestMother.withValidAnswers()
            matchingDogsService.getMatchingTemperaments(_, _) >> [TemperamentValue.ALERT, TemperamentValue.AFFECTIONATE]
            dogRepository.findByTemperaments(_) >> [DogMother.random()]
        when:
            def result = findMatchingDogs.find(validRequest)
        then:
            result.matchingDogs.size() == 1
    }

    def "Given a request with invalid answers then a FindMatchingDogsException is thrown"() {
        given:
            def wrongRequest = FindMatchingDogsRequestMother.withInvalidAnswers()
        when:
            findMatchingDogs.find(wrongRequest)
        then:
            thrown(FindMatchingDogsException)
    }
}
