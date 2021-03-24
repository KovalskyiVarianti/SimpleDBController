package specification.file

import entities.Entity
import java.io.File

class InsertFileSpecification<T:Entity>(private val item: T) : FileSpecification<T> {
    override fun executeAlgorithm(file: File) {
        file.appendText("$item${System.lineSeparator()}")
    }
}