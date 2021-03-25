package commands.standart

import commands.Command
import commands.splitToEntity
import de.vandermeer.asciitable.AsciiTable
import entities.Clothes
import repository.Repository

class PrintAllClothesCommand(private val repository: Repository<Clothes>) : Command {
    override fun commandName(): String = "Print all clothes"

    override fun execute() {
        val table = AsciiTable()
        table.addRule()
        table.addRow(Clothes.getFieldsNames().map { it.toUpperCase() })
        repository.showAll().forEach { clothes ->
            table.addRule()
            val (id, type, category, brand, color, size) = clothes
            table.addRow(id, type, category, brand, color, size)
        }
        table.addRule()
        println(table.render())
    }

}