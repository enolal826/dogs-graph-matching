package dogs.domain.entity

import dogs.domain.value_object.BreedValue
import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
class Breed(val value: BreedValue)