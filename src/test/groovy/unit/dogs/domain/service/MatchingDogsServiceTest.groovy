package dogs.domain.service

import dogs.domain.value_object.HomeTypeAnswer
import dogs.domain.value_object.TimeAtHomeAnswer
import spock.lang.Specification
import spock.lang.Unroll

class MatchingDogsServiceTest extends Specification {

   private MatchingDogsService matchingDogsService;

    def setup() {
        this.matchingDogsService = new MatchingDogsService()
    }

    @Unroll
    def "Given #homeTypeAnswer temperaments and #timeAtHomeAnswer temperaments then they must merged"() {
        when:
            def result = matchingDogsService.getMatchingTemperaments(homeTypeAnswer, timeAtHomeAnswer)
        then:
            println(result)
            result.sort() == new HashSet(homeTypeAnswer.associatedTemperaments + timeAtHomeAnswer.associatedTemperaments).toList().sort()
        where:
            homeTypeAnswer                  | timeAtHomeAnswer
            HomeTypeAnswer.SMALL_FLAT       | TimeAtHomeAnswer.LESS_THAN_4_HOURS
            HomeTypeAnswer.BIG_FLAT         | TimeAtHomeAnswer.FROM_4_TO_9_HOURS
            HomeTypeAnswer.HOUSE_WITH_YARD  | TimeAtHomeAnswer.MORE_THAN_10_HOURS
    }
}
