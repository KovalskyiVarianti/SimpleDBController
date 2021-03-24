package specification.file

import entities.Entity
import specification.ReturnableSpecification
import java.io.File

interface FileReturnableSpecification<T:Entity> : ReturnableSpecification<T> {
    fun getResult(file : File):List<String>
}