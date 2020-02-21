package dogs.domain.entity

import dogs.domain.value_object.TemperamentValue
import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
class Temperament(val value: TemperamentValue)