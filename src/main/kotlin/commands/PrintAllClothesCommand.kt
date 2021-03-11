package commands

import entities.Clothes
import repository.Repository

class PrintAllClothesCommand(private val repository: Repository<Clothes>) : Command {
    override fun commandName(): String = "Print all clothes"

    override fun execute() {
        repository.showAll().forEach { println(it.bdRepresentation()) }
    }

}