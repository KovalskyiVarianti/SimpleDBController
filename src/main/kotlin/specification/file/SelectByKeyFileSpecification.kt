package specification.file

import java.io.File

class SelectByKeyFileSpecification(private val pair: Pair<String, String>) : FileReturnableSpecification {
    override fun getResult(file: File): List<String> =
        file.readLines().filter {
            it.contains("${pair.first}=${pair.second}", true)
        }
}


