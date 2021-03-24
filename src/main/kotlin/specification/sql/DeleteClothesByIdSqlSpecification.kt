package specification.sql

import entities.Entity

class DeleteClothesByIdSqlSpecification<T:Entity>(private val id: Int) : SqlSpecification<T> {
    override fun toSqlQuery(): String = "DELETE FROM clothes WHERE id = $id"
}