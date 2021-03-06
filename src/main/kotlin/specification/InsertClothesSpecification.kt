package specification

import entities.Clothes

inline class InsertClothesSpecification(private val clothes: Clothes) : SqlSpecification {
    override fun toSqlQuery(): String = "INSERT INTO ${getClothesColumns()} ${getValues(clothes)}"


    private fun getClothesColumns() = "`clothes` (`id`, `type`, `category`, `brand`, `color`, `size`) "

    private fun getValues(clothes: Clothes) = "VALUES ( " +
            "'${clothes.id}'," +
            "'${clothes.type}', " +
            "'${clothes.category}', " +
            "'${clothes.brand}', " +
            "'${clothes.color}', " +
            "'${clothes.size}'" +
            ");"


}