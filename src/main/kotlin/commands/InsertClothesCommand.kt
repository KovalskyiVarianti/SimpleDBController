package commands

import entities.Clothes
import repository.Repository

class InsertClothesCommand(private val repository: Repository<Clothes>) : Command {
    override fun commandName(): String = "Insert clothes"

    override fun execute() {
        println("Please, fill in all columns")
        println("id, type, category, brand, color, size")
        println("Example:\n1, boots, man, dolce gabbana, white, XXL")
        val input = readLine()
        val list = input!!.split(",").map { it.trim() }
        repository.add(
            Clothes(
                list[0].toInt(),
                list[1],
                list[2],
                list[3],
                list[4],
                list[5],
            )
        )
        println("Insertion was successful!")
    }
}