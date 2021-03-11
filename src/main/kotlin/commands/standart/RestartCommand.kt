package commands.standart

import commands.Command

class RestartCommand : Command {
    override fun commandName(): String = "Restart program"

    override fun execute() {
        App.start()
    }
}