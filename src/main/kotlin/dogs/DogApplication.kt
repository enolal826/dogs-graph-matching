package dogs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories

@SpringBootApplication
@EnableNeo4jRepositories("dogs.infrastructure.db.repository")
class DogApplication

fun main(args: Array<String>) {
	runApplication<DogApplication>(*args)
}