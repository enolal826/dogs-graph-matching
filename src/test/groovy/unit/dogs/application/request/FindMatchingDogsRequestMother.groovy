package dogs.application.request

import dogs.application.dogs.request.FindMatchingDogsRequest

class FindMatchingDogsRequestMother {

    static withValidAnswers() {
        return new FindMatchingDogsRequest("small_flat", "less_than_4_hours")
    }

    static withInvalidAnswers() {
        return new FindMatchingDogsRequest("anything", "anything")
    }
}
