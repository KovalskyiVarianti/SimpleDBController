package commands.file

import commands.Command
import commands.readPair
import entities.Clothes
import repository.Repository
import specification.file.DeleteByKeyFileSpecification

class DeleteClothesByKeyCommand(private val repository: Repository<Clothes>): Command {
    override fun commandName(): String = "Delete by key"

    override fun execute() {
        repository.query(DeleteByKeyFileSpecification(readPair()))
        println("Removing was successful!")
    }
}