package commands.file

import commands.Command
import commands.readPair
import de.vandermeer.asciitable.AsciiTable
import entities.Clothes
import repository.Repository
import specification.file.SelectByKeyFileSpecification

class SelectClothesByKeyCommand(private val repository: Repository<Clothes>) : Command {
    override fun commandName(): String = "Select by key"

    override fun execute() {
        val table = AsciiTable()
        table.addRule()
        table.addRow(Clothes.getFieldsNames().map { it.toUpperCase() })
        repository.query(SelectByKeyFileSpecification(readPair())).forEach { string ->
            table.addRule()
            table.addRow()
        }
        table.addRule()
        println(table.render())

    }
}