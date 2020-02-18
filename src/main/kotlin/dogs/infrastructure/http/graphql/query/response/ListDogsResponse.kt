package dogs.infrastructure.http.graphql.query.response

import dogs.infrastructure.http.graphql.core.Dog

class ListDogsResponse(val content: List<Dog>, val hasMore: Boolean)