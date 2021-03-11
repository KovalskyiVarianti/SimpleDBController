package commands

interface Command {
    fun commandName(): String
    fun execute()
}