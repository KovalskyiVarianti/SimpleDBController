package specification.file

import entities.Entity
import java.io.File

class DeleteFileSpecification<T:Entity>(private val id: Int) : FileSpecification<T> {
    override fun executeAlgorithm(file: File) {
        val temp = File("temp")
        file.forEachLine {
            if (!it.contains("id=$id")) {
                temp.appendText("$it\n")
            }
        }
        file.delete()
        temp.renameTo(file)
    }
}