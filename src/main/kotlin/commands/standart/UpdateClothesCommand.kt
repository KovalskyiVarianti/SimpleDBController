package commands.standart

import commands.Command
import commands.readId
import commands.readMatch
import entities.Clothes
import entities.EntityParser
import repository.Repository

class UpdateClothesCommand(private val repository: Repository<Clothes>) : Command {
    override fun commandName(): String = "Update clothes"

    override fun execute() {
        val id = readId()
        println("Please, fill in all columns")
        println("type, category, brand, color, size")
        println("Example:\nboots, man, dolce gabbana, white, XXL")
        val input = readMatch(regex)
        val list = input.split(",").map { it.trim() as Any? }.toMutableList()
        list.add(0, id)
        repository.update(EntityParser.parseClothes(list.joinToString(",")))
        println("Update was successful!")
    }

    private val regex: Regex = Regex("[ ]*[\\w ]+?,[ ]*[\\w ]+?,[ ]*[\\w ]+?,[ ]*[\\w ]+?,[ ]*[\\w ]+")
}