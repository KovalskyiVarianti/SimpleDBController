package commands

class CommandMatcher(private val commandList: Set<Command>) {

    fun run(message: String) {
        for (command in commandList) {
            if (command.commandName().startsWith(message, ignoreCase = true)) {
                return command.execute()
            }
        }
        println("Command doesn't exist.Try again.")
    }

    fun printALlCommands() {
        println()
        println("Please choose one of the commands:")
        commandList.forEachIndexed { index, command ->
            println("${index + 1}) Command: ${command.commandName()}")
            println("------------------------------------------------")
        }
    }
}