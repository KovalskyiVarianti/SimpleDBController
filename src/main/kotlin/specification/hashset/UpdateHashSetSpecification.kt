package specification.hashset

import entities.Entity
import java.util.*

class UpdateHashSetSpecification<T:Entity>(private val item: T) : HashSetSpecification<T> {
    override fun executeAlgorithm(hashSet: HashSet<T>) {
        hashSet.removeIf { it.id == item.id }
        hashSet.add(item)
    }

}