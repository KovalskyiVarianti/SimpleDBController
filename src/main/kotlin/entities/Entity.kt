package entities

import java.io.Serializable

sealed class Entity(open val id: Int) : Serializable

data class Clothes(
    override val id: Int,
    val type: String,
    val category: String,
    val brand: String,
    val color: String,
    val size: String,
) : Entity(id), Serializable {

    override fun hashCode(): Int = id % 12
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Clothes

        if (id != other.id) return false

        return true
    }

    companion object {
        fun getFieldsNames() = Clothes::class.java.declaredFields.map { it.name }.filterNot { it == "Companion" }
    }
}