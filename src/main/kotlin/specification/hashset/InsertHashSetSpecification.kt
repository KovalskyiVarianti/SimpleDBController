package specification.hashset

import entities.Entity

class InsertHashSetSpecification<T:Entity>(private val item: T) : HashSetSpecification<T> {
    override fun executeAlgorithm(hashSet: HashSet<T>) {
        hashSet.add(item)
    }
}