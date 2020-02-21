package dogs.domain.value_object

import dogs.domain.exception.TimeAtHomeAnswerExternalInputNotValidException

enum class TimeAtHomeAnswer(val associatedTemperaments: List<TemperamentValue>) {
    LESS_THAN_4_HOURS(emptyList()),
    FROM_4_TO_9_HOURS(emptyList()),
    MORE_THAN_10_HOURS(emptyList());

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