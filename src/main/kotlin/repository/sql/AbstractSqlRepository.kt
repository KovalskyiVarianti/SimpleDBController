package repository.sql
/*
import entities.Clothes
import provider.ConnectionProvider
import repository.Repository
import specification.ReturnableSpecification
import specification.Specification
import specification.sql.SqlSpecification
import java.sql.ResultSet

abstract class AbstractSqlRepository(private val connectionProvider: ConnectionProvider) : Repository<Clothes> {

    protected fun execute(sqlSpecification: SqlSpecification) =
        connectionProvider.getConnection().prepareStatement(sqlSpecification.toSqlQuery()).execute()

    protected fun executeQuery(sqlSpecification: SqlSpecification): ResultSet =
        connectionProvider.getConnection().prepareStatement(sqlSpecification.toSqlQuery()).executeQuery()

    protected fun castToReturnableSqlSpec(returnableSpecification: ReturnableSpecification<T>) =
        returnableSpecification as SqlSpecification

    protected fun castToSqlSpec(specification: Specification<T>) =
        specification as SqlSpecification
}*/