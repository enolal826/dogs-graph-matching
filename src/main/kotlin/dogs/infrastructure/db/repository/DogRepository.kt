package dogs.infrastructure.db.repository

import dogs.domain.entity.Dog
import dogs.domain.value_object.TemperamentValue
import org.springframework.data.neo4j.annotation.Query
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.repository.query.Param

interface DogRepository: Neo4jRepository<Dog, Int> {
    @Query("MATCH (d:Dog),(b:Breed),(t:Temperament) WHERE ((d)-->(t) OR (d)-->(b)-->(t)) AND t.value IN {temperamentValueList} RETURN d")
    fun findByTemperaments(@Param("temperamentValueList") temperamentValueList: List<TemperamentValue>): List<Dog>
    @Query("MATCH (d:Dog) RETURN d SKIP {offset} LIMIT {limit}")
    fun findAllByOffsetAndLimit(@Param("offset") offset: Int, @Param("limit") limit: Int): List<Dog>
}