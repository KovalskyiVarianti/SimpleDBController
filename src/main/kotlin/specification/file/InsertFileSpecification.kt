package specification.file

import entities.Clothes
import java.io.File

class InsertFileSpecification<T>(private val item: T) : FileSpecification {
    override fun executeAlgorithm(file: File) {
        file.appendText("$item${System.lineSeparator()}")
    }
}