package commands

import entities.Clothes
import repository.Repository
import specification.file.DeleteByKeyFileSpecification

class DeleteClothesByKeyCommand(private val repository: Repository<Clothes>):Command {
    override fun commandName(): String = "Delete by key"

    override fun execute() {
        println("Please, insert name of column:")
        val key = readLine() as String
        println("Please, insert value of column:")
        val value = readLine() as String
        repository.query(DeleteByKeyFileSpecification(key to value))
        println("Removing was successful!")
    }
}