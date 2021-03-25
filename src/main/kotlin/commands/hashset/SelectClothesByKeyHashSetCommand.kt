package commands.hashset

import commands.Command
import commands.readPair
import commands.splitToEntity
import de.vandermeer.asciitable.AsciiTable
import entities.Clothes
import repository.Repository
import specification.hashset.SelectByKeyHashSetSpecification

class SelectClothesByKeyHashSetCommand(private val repository: Repository<Clothes>) : Command {
    override fun commandName(): String = "Select by key"

    override fun execute() {
        val table = AsciiTable()
        table.addRule()
        table.addRow(Clothes.getFieldsNames().map { it.toUpperCase() })
        repository.query(SelectByKeyHashSetSpecification(readPair())).forEach { clothes ->
            table.addRule()
            val (id, type, category, brand, color, size) = clothes
            table.addRow(id, type, category, brand, color, size)
        }
        table.addRule()
        println(table.render())

    }
}