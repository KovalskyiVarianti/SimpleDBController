package specification.file

import entities.Entity
import java.io.File

class SelectByKeyFileSpecification<T: Entity>(private val pair: Pair<String, String>) : FileReturnableSpecification<T> {
    override fun getResult(file: File): List<String> =
        file.readLines().filter {
            it.contains("${pair.first}=${pair.second}[,)]".toRegex())
        }
}


