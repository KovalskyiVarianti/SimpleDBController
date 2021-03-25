package commands

fun readPair(): Pair<String, String> {
    println("Please, insert name of column:")
    val key = readLine()!!.trim()
    println("Please, insert value of column:")
    val value = readLine()!!.trim()
    return key to value
}

fun readId(): Int {
    println("Please, write id:")
    return try {
        readLine()!!.toInt()
    } catch (e: NumberFormatException){
        println("Invalid input!!!")
        readId()
    }
}

fun readMatch(regex: Regex) : String{
    val input = readLine()!!.trim()
    if (!input.matches(regex)){
        println("Wrong input! Try again")
        return readMatch(regex)
    }
    return input
}

fun String.splitToEntity() = split(",").map { it.trim() }.map { it.split("=")[1].substringBefore(")")}
