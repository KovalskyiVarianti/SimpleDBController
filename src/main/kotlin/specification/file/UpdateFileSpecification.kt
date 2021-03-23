package specification.file

import java.io.File

class UpdateFileSpecification<T>(private val id: Int, private val item: T) : FileSpecification {
    override fun executeAlgorithm(file: File) {
        val temp = File("temp")
        file.forEachLine {
            if (it.contains("id=$id")) {
                temp.appendText("$item\n")
            } else {
                temp.appendText("$it\n")
            }
        }
        file.delete()
        temp.renameTo(file)
    }
}