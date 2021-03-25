package specification.hashset

import entities.Entity
import specification.Specification
import java.util.HashSet

interface HashSetSpecification<T:Entity> : Specification<T>{
    fun executeAlgorithm(hashSet : HashSet<T>)
}