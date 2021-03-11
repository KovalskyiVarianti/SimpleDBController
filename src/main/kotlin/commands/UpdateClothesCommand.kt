package commands

import entities.Clothes
import repository.Repository

class UpdateClothesCommand(private val repository: Repository<Clothes>) : Command {
    override fun commandName(): String = "Update clothes"

    override fun execute() {
        println("Please, write id of clothes:")
        val id = handleCast(readLine()!!)
        println("Please, fill in all columns")
        println("type, category, brand, color, size")
        println("Example:\nboots, man, dolce gabbana, white, XXL")
        val input = readLine()
        if (!input!!.matches(regex)) {
            println("Wrong input! Try again")
            execute()
            return
        }
        val list = input.split(",").map { it.trim() }
        repository.update(
            Clothes(
                id,
                list[0],
                list[1],
                list[2],
                list[3],
                list[4]
            )
        )
        println("Update was successful!")
    }

    private fun handleCast(string: String): Int =
        try {
            string.toInt()
        } catch (e: NumberFormatException) {
            println("Please, input valid number")
            handleCast(readLine()!!)
        }

    private val regex : Regex = Regex("[ ]*[\\w ]+?,[ ]*[\\w ]+?,[ ]*[\\w ]+?,[ ]*[\\w ]+?,[ ]*[\\w ]+")
}