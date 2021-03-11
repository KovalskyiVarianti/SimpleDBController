package commands.standart

import commands.Command
import entities.Clothes
import repository.Repository

class DeleteClothesCommand(private val repository: Repository<Clothes>) : Command {
    override fun commandName(): String = "Delete clothes"

    override fun execute() {
        println("Please, write id of clothes:")
        val id = handleCast(readLine()!!)
        repository.remove(id)
        println("Removal was successful!")
    }

    private fun handleCast(string: String): Int =
        try {
            string.toInt()
        } catch (e: NumberFormatException) {
            println("Please, input valid number")
            handleCast(readLine()!!)
        }

}