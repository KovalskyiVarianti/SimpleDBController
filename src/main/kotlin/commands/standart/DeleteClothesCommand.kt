package commands.standart

import commands.Command
import commands.readId
import entities.Clothes
import repository.Repository

class DeleteClothesCommand(private val repository: Repository<Clothes>) : Command {
    override fun commandName(): String = "Delete clothes"

    override fun execute() {
        println("Please, write id of clothes:")
        val id = readId()
        repository.remove(id)
        println("Removal was successful!")
    }

}