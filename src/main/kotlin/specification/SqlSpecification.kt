package specification

interface SqlSpecification : Specification {
    fun toSqlQuery(): String
}