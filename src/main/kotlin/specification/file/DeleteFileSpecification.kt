package specification.file

import java.io.File

class DeleteFileSpecification(private val id: Int) : FileSpecification {
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