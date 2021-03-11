package specification.file

import specification.ReturnableSpecification
import java.io.File

interface FileReturnableSpecification : ReturnableSpecification {
    fun getResult(file : File):List<String>
}