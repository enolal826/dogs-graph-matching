package dogs.domain.value_object

import dogs.domain.exception.HomeTypeAnswerExternalInputNotValidException

enum class HomeTypeAnswer(val associatedTemperaments: List<TemperamentValue>){
    SMALL_FLAT(listOf(TemperamentValue.LOYAL)),
    BIG_FLAT(emptyList()),
    HOUSE_WITH_YARD(emptyList()),
    HOUSE_WITHOUT_YARD(emptyList());

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