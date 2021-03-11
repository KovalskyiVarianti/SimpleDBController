import commands.*
import entities.Clothes
import repository.Repository
import repository.file.ClothesFileRepository
import repository.sql.ClothesSqlRepository

object App {
    fun start() {
        val rep = getClothRepository() as ClothesFileRepository
        val setOfCommands = setOf(
            PrintAllClothesCommand(rep),
            SelectClothesByKeyCommand(rep),
            InsertClothesCommand(rep),
            UpdateClothesCommand(rep),
            DeleteClothesCommand(rep),
            DeleteClothesByKeyCommand(rep),
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