package specification.sql

import specification.ReturnableSpecification

class SelectAllClothesSqlSpecification : SqlSpecification, ReturnableSpecification {
    override fun toSqlQuery(): String =
        "SELECT * FROM clothes;"
}