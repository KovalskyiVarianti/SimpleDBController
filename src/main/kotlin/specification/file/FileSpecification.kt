package specification.file

import entities.Entity
import specification.Specification
import java.io.File

interface FileSpecification<T:Entity> : Specification<T>{
    fun executeAlgorithm(file : File)
}