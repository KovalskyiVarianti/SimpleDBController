package commands

import entities.Clothes
import repository.Repository
import repository.file.ClothesFileRepository
import specification.file.SelectByKeyFileSpecification

class SelectClothesByKeyCommand(private val repository: ClothesFileRepository) : Command {
    override fun commandName(): String = "Select by key"

    override fun execute() {
        println("Please, insert name of column:")
        val key = (readLine() as String).trim()
        println("Please, insert value of column:")
        val value = (readLine() as String).trim()
        repository.query(SelectByKeyFileSpecification(key to value)).forEach { println(it.bdRepresentation()) }
    }
}