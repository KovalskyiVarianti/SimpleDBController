import commands.*
import entities.Clothes
import repository.Repository
import repository.file.ClothesFileRepository
import repository.sql.ClothesSqlRepository

object App {
    fun start() {
        val rep = getClothRepository()
        val setOfCommands = setOf(
            PrintAllClothesCommand(rep),
            InsertClothesCommand(rep),
            UpdateClothesCommand(rep),
            DeleteClothesCommand(rep),
            ExitAppCommand()
        )
        val commandMatcher = CommandMatcher(setOfCommands)
        AppController(commandMatcher).start()
    }

    private fun getClothRepository(): Repository<Clothes> = ClothesFileRepository()
}

fun main() {
    App.start()
}