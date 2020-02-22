package dogs.infrastructure.http.graphql.query.output

import dogs.infrastructure.http.graphql.core.Dog

class ListDogsOutput(val content: List<Dog>, val hasMore: Boolean)