package specification.sql

class DeleteClothesByIdSqlSpecification(private val id: Int) : SqlSpecification {
    override fun toSqlQuery(): String = "DELETE FROM clothes WHERE id = $id"
}