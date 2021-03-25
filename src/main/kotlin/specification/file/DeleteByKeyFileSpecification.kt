package specification.file

import entities.Entity
import java.io.File

class DeleteByKeyFileSpecification<T:Entity>(private val pair: Pair<String, String>) : FileSpecification<T> {
    override fun executeAlgorithm(file: File) {
        val temp = File("temp")
        file.forEachLine {
            if (!it.contains("${pair.first}=${pair.second}[,)]".toRegex())) {
                temp.appendText("$it\n")
            }
        }
        file.delete()
        temp.renameTo(file)
    }
}