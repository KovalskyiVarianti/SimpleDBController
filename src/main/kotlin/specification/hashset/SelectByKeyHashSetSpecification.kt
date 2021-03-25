package specification.hashset

import entities.Entity

class SelectByKeyHashSetSpecification<T:Entity>(private val pair: Pair<String, String>) : HashSetReturnableSpecification<T> {

    override fun getResult(hashSet: HashSet<T>): List<String> =
        hashSet.toList().filter {
            it.toString().contains("${pair.first}=${pair.second}", true)
        }.map { it.toString() }
}


