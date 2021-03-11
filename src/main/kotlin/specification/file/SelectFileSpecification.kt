package specification.file

import java.io.File

class SelectFileSpecification:FileReturnableSpecification {
    override fun getResult(file: File): List<String> = file.readLines()
}