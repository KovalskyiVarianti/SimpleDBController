package specification.file

import java.io.File

class DeleteByKeyFileSpecification(private val pair: Pair<String, String>) : FileSpecification {
    override fun executeAlgorithm(file: File) {
        val temp = File("temp")
        val lines = file.readLines().toMutableList()
        lines.forEach {
            if (!it.contains("${pair.first}=${pair.second}")) {
                temp.appendText("$it\n")
            }
        }
        file.delete()
        temp.renameTo(file)

    }
}