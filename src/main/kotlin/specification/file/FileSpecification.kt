package specification.file

import specification.Specification
import java.io.File

interface FileSpecification : Specification{
    fun executeAlgorithm(file : File)
}