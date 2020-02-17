package dogs.domain.entity

import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
class Dog(val name: String, val age: Int, val size: String)