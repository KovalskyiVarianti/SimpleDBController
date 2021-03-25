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
        repository.showAll().forEach { string ->
            table.addRule()
            table.addRow(string.splitToEntity())
        }
        table.addRule()
        println(table.render())
    }

}