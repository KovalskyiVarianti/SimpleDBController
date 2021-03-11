package specification.sql

import specification.Specification

interface SqlSpecification : Specification {
    fun toSqlQuery(): String
}