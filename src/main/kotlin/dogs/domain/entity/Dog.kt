package dogs.domain.entity

import org.neo4j.ogm.annotation.NodeEntity

@NodeEntity
class Dog(val name: String, val age: Int?, val size: String?) {
    override fun toString(): String {
        return "Dog(name='$name', age=$age, size=$size)"
    }
}