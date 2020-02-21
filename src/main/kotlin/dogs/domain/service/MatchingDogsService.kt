package dogs.domain.service

import dogs.domain.value_object.HomeTypeAnswer
import dogs.domain.value_object.TemperamentValue
import dogs.domain.value_object.TimeAtHomeAnswer
import org.springframework.stereotype.Service

@Service
class MatchingDogsService {

    fun getMatchingTemperaments(homeTypeAnswer: HomeTypeAnswer, timeAtHomeAnswer: TimeAtHomeAnswer): List<TemperamentValue> {
        val temperaments = mutableSetOf<TemperamentValue>()
        homeTypeAnswer.associatedTemperaments.forEach { temperaments.add(it) }
        timeAtHomeAnswer.associatedTemperaments.forEach { temperaments.add(it) }

        return temperaments.toList()
    }
}