package entities

data class Clothes(
    val id: Int,
    val type: String,
    val category: String,
    val brand: String,
    val color: String,
    val size: String
){
    fun bdRepresentation() = "|\t$id\t|\t$type\t|\t$category\t|\t$brand\t|\t$type\t|\t$color\t|\t$size\t|"
}