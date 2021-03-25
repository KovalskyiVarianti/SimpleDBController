package specification.hashset

import entities.Entity

class SelectHashSetSpecification<T:Entity>:HashSetReturnableSpecification<T> {
    override fun getResult(hashSet: HashSet<T>): List<String> = hashSet.map { it.toString() }.toList()
}