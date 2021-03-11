package commands.standart

import commands.Command
import entities.Clothes
import repository.Repository

class InsertClothesCommand(private val repository: Repository<Clothes>) : Command {
    override fun commandName(): String = "Insert clothes"

    override fun execute() {
        println("Please, fill in all columns")
        println("id, type, category, brand, color, size")
        println("Example:\n1, boots, man, dolce gabbana, white, XXL")
        val input = readLine()
        if (!input!!.matches(regex)) {
            println("Wrong input! Try again")
            execute()
            return
        }
        val list = input.split(",").map { it.trim() }
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

    private val regex : Regex = Regex("\\d+,[ ]*[\\w ]+?,[ ]*[\\w ]+?,[ ]*[\\w ]+?,[ ]*[\\w ]+?,[ ]*[\\w ]+")
}