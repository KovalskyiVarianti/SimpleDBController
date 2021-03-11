package specification.sql

import entities.Clothes

class UpdateClothesSqlSpecification(private val clothes: Clothes) : SqlSpecification {
    override fun toSqlQuery(): String = "UPDATE clothes\n" +
            "SET type = '${clothes.type}'," +
            " category = '${clothes.category}'," +
            " brand = '${clothes.brand}'," +
            " color = '${clothes.color}'," +
            " size = '${clothes.size}'\n" +
            "WHERE id = ${clothes.id}"
}