package specification.sql
/*
import entities.Clothes
import entities.Entity

class InsertClothesSqlSpecification<T:Entity>(private val item: T) : SqlSpecification<T> {
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


}*/