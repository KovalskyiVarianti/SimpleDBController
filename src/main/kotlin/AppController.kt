import commands.CommandMatcher

class AppController(
    private val commandMatcher: CommandMatcher
) {
    fun start() {
        while (true) {
            commandMatcher.printALlCommands()
            println("Please enter command:")
            val userInput = readLine().orEmpty()
            commandMatcher.run(userInput)
            println("Push Enter to continue...")
            waitForEnter(readLine())
        }
    }

    private fun waitForEnter(input: String?) {
        if (input.orEmpty().isBlank()) {
            return
        } else {
            waitForEnter(readLine())
        }
    }
}