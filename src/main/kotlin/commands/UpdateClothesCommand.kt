package commands

import entities.Clothes
import repository.Repository

class UpdateClothesCommand(private val repository: Repository<Clothes>) : Command {
    override fun commandName(): String = "Update clothes"

    override fun execute() {
        println("Please, write id of clothes:")
        val id = readLine()!!.toInt()
        println("Please, fill in all columns")
        println("type, category, brand, color, size")
        println("Example:\nboots, man, dolce gabbana, white, XXL")
        val input = readLine()
        val list = input!!.split(",")
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
}