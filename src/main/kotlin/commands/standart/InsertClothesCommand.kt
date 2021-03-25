package commands.standart

import commands.Command
import commands.readMatch
import entities.Clothes
import entities.EntityParser
import repository.Repository

class InsertClothesCommand(private val repository: Repository<Clothes>) : Command {
    override fun commandName(): String = "Insert clothes"

    override fun execute() {
        println("Please, fill in all columns")
        println("id, type, category, brand, color, size")
        println("Example:\n1, boots, man, dolce gabbana, white, XXL")
        repository.add(EntityParser.parseClothes(readMatch(regex)))
        println("Insertion was successful!")
    }

    private val regex: Regex = Regex("\\d+,[ ]*[\\w ]+?,[ ]*[\\w ]+?,[ ]*[\\w ]+?,[ ]*[\\w ]+?,[ ]*[\\w ]+")
}