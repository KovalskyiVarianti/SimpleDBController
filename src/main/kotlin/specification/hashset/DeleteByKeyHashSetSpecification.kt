package specification.hashset

import entities.Entity

class DeleteByKeyHashSetSpecification<T : Entity>(private val pair: Pair<String, String>) : HashSetSpecification<T> {
    override fun executeAlgorithm(hashSet: HashSet<T>) {
        hashSet.removeIf { it.toString().contains("${pair.first}=${pair.second}", true) }
    }
}