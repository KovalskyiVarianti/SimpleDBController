package commands.standart

import commands.Command
import kotlin.system.exitProcess

class ExitAppCommand : Command {
    override fun commandName(): String = "Exit"

    override fun execute() {
        exitProcess(0)
    }
}