import commands.*
import commands.file.DeleteClothesByKeyCommand
import commands.file.SelectClothesByKeyCommand
import commands.standart.*
import de.vandermeer.asciitable.AsciiTable
import entities.Clothes
import repository.Repository
import repository.file.ClothesFileRepository
import repository.sql.ClothesSqlRepository

object App {
    fun start() {
        val rep = getClothRepository()
        val commandMatcher = CommandMatcher(getCommands(rep))
        AppController(commandMatcher).start()
    }

    private fun getClothRepository(): Repository<Clothes> {
        println("Choose repository:")
        val repositories = listOf(ClothesSqlRepository(), ClothesFileRepository())
        repositories.forEachIndexed { index, repository ->
            println("${index + 1}. ${repository.javaClass.simpleName}")
        }
        val number = handleCast(readLine()!!)
        if (number !in 1..repositories.size){
            println("Choose existing one!")
            return getClothRepository()
        }
        return repositories[number - 1]
    }

    private fun getCommands(rep: Repository<Clothes>) = when(rep){
        is ClothesFileRepository -> getFileCommands(rep) + getDefaultCommands(rep)
        is ClothesSqlRepository -> getSqlCommands(rep) + getDefaultCommands(rep)
        else -> getDefaultCommands(rep)
    }

    private fun handleCast(string: String): Int =
        try {
            string.toInt()
        } catch (e: NumberFormatException) {
            println("Please, input valid number")
            handleCast(readLine()!!)
        }

    private fun getSqlCommands(rep: Repository<Clothes>) = setOf<Command>()

    private fun getFileCommands(rep: Repository<Clothes>) = setOf(
        SelectClothesByKeyCommand(rep),
        DeleteClothesByKeyCommand(rep)
    )

    private fun getDefaultCommands(rep: Repository<Clothes>) = setOf(
        PrintAllClothesCommand(rep),
        InsertClothesCommand(rep),
        UpdateClothesCommand(rep),
        DeleteClothesCommand(rep),
        ExitAppCommand(),
        RestartCommand()
    )
}

fun main() {
    App.start()
}