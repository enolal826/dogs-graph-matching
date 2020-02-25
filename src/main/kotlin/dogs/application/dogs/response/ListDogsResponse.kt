package dogs.application.dogs.response

import dogs.domain.entity.Dog

class ListDogsResponse(val dogs: List<Dog>, val totalCount: Int)