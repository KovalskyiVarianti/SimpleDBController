package entities

sealed class Entity {
    abstract fun bdRepresentation(): String
    fun getFieldsNames() = this.javaClass.declaredFields.map { it.name }
    fun getValues() = getFieldsNames().map { getValue(it) }
    fun getValue(property: String) =
        this::class.members.first {
            property == it.name
        }.call(this)

}

data class Clothes(
    val id: Int,
    val type: String,
    val category: String,
    val brand: String,
    val color: String,
    val size: String,
) : Entity() {
    override fun bdRepresentation() = toString().substringAfter("(").substringBefore(")")
}
/*= "|\t$id\t|\t$type\t|\t$category\t|\t$brand\t|\t$type\t|\t$color\t|\t$size\t|"*/