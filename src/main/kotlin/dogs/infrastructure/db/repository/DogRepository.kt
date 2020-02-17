package dogs.infrastructure.db.repository

import dogs.domain.entity.Dog
import org.springframework.data.neo4j.repository.Neo4jRepository

interface DogRepository : Neo4jRepository<Dog, Int> {
    fun findByName(name: String): Dog
}