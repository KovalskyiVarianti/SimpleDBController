package specification.sql

import entities.Entity
import specification.Specification

interface SqlSpecification<T:Entity> : Specification<T> {
    fun toSqlQuery(): String
}