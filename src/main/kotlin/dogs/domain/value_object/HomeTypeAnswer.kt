package dogs.domain.value_object

import dogs.domain.exception.HomeTypeAnswerExternalInputNotValidException

enum class HomeTypeAnswer(val associatedTemperaments: List<TemperamentValue>){
    SMALL_FLAT(listOf(TemperamentValue.QUIET, TemperamentValue.PATIENT, TemperamentValue.SOCIABLE, TemperamentValue.OBEDIENT)),
    BIG_FLAT(listOf(TemperamentValue.ACTIVE, TemperamentValue.SOCIABLE, TemperamentValue.OBEDIENT)),
    HOUSE_WITH_YARD(listOf(TemperamentValue.EASYGOING, TemperamentValue.CURIOUS, TemperamentValue.FEARLESS)),
    HOUSE_WITHOUT_YARD(listOf(TemperamentValue.DOCILE));

    companion object Factory {
        fun fromExternalString(homeTypeAnswerExternalString: String): HomeTypeAnswer {
            return when(homeTypeAnswerExternalString) {
                "small_flat" -> SMALL_FLAT
                "big_flat" -> BIG_FLAT
                "house_with_yard" -> HOUSE_WITH_YARD
                "house_without_yard" -> HOUSE_WITHOUT_YARD
                else -> throw HomeTypeAnswerExternalInputNotValidException()
            }
        }
    }
}