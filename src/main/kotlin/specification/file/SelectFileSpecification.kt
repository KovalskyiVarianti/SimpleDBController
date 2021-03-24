package specification.file

import entities.Entity
import java.io.File

class SelectFileSpecification<T:Entity>:FileReturnableSpecification<T> {
    override fun getResult(file: File): List<String> = file.readLines()
}