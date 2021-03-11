package repository.sql

import repository.Repository
import repository.provider.ConnectionProvider
import specification.*
import specification.sql.SqlSpecification
import java.sql.ResultSet

abstract class AbstractSqlRepository<T>(private val connectionProvider: ConnectionProvider) : Repository<T> {

    protected fun execute(sqlSpecification: SqlSpecification) =
        connectionProvider.getConnection().prepareStatement(sqlSpecification.toSqlQuery()).execute()

    protected fun executeQuery(sqlSpecification: SqlSpecification): ResultSet =
        connectionProvider.getConnection().prepareStatement(sqlSpecification.toSqlQuery()).executeQuery()

    protected fun castToSqlSpec(specification: Specification) = specification as SqlSpecification

}