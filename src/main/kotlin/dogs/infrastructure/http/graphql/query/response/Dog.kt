package dogs.infrastructure.http.graphql.query.response

data class Dog(val name: String, val age: Int, val breed: String, val temperament: List<String>)