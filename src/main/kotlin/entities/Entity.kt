package entities

sealed class Entity

data class Clothes(
    val id: Int,
    val type: String,
    val category: String,
    val brand: String,
    val color: String,
    val size: String,
) : Entity() {
    companion object {
        fun createClothes(list: List<*>): Clothes {
            val it = list.iterator()
            return Clothes(
                it.next().toString().toInt(),
                it.next() as String,
                it.next() as String,
                it.next() as String,
                it.next() as String,
                it.next() as String,
            )
        }
        fun getFieldsNames() = Clothes::class.java.declaredFields.map { it.name }.filterNot { it == "Companion" }
    }
}