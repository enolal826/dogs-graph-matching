package dogs.domain.value_object

import dogs.domain.exception.TimeAtHomeAnswerExternalInputNotValidException

enum class TimeAtHomeAnswer(val associatedTemperaments: List<TemperamentValue>) {
    LESS_THAN_4_HOURS(listOf(TemperamentValue.INDEPENDENT, TemperamentValue.DOCILE, TemperamentValue.PATIENT, TemperamentValue.QUIET)),
    FROM_4_TO_9_HOURS(listOf(TemperamentValue.STEADY, TemperamentValue.INDEPENDENT)),
    MORE_THAN_10_HOURS(listOf(TemperamentValue.PLAYFUL, TemperamentValue.EASYGOING));

    companion object Factory {
        fun fromExternalString(timeAtHomeAnswerExternalString: String): TimeAtHomeAnswer {
            return when(timeAtHomeAnswerExternalString) {
                "less_than_4_hours" -> LESS_THAN_4_HOURS
                "from_4_to_9_hours" -> FROM_4_TO_9_HOURS
                "MORE_THAN_10_HOURS" -> MORE_THAN_10_HOURS
                else -> throw TimeAtHomeAnswerExternalInputNotValidException()
            }
        }
    }
}