package specification.hashset

import entities.Entity
import specification.ReturnableSpecification

interface HashSetReturnableSpecification<T : Entity> : ReturnableSpecification<T> {
    fun getResult(hashSet: HashSet<T>): List<String>
}