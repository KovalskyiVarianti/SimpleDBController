package repository.sql

/*
import entities.Clothes
import entities.Entity
import repository.sql.AbstractSqlRepository
import provider.ConnectionProvider
import provider.MySqlConnectionProvider
import specification.*
import specification.sql.DeleteClothesByIdSqlSpecification
import specification.sql.InsertClothesSqlSpecification
import specification.sql.SelectAllClothesSqlSpecification
import specification.sql.UpdateClothesSqlSpecification
import java.sql.ResultSet

class ClothesSqlRepository(
    connectionProvider: ConnectionProvider = MySqlConnectionProvider("mydb")
) :
    AbstractSqlRepository<Clothes>(connectionProvider) {

    override fun add(item: T) {
        execute(InsertClothesSqlSpecification(item))
    }

    override fun remove(fieldName: String, fieldValue: String) {
        execute(DeleteClothesByIdSqlSpecification(fieldName to fieldValue))
    }

    override fun update(item: T) {
        execute(UpdateClothesSqlSpecification(item))
    }

    override fun showAll(): List<T> =
        collectValues(executeQuery(SelectAllClothesSqlSpecification()))

    override fun <S : Specification<T>> query(specification: S) {
        execute(castToSqlSpec(specification))
    }

    override fun <S : ReturnableSpecification<T>> query(returnableSpecification: S): List<String> {
        val sqlSpecification = castToReturnableSqlSpec(returnableSpecification)
        return collectValues(executeQuery(sqlSpecification))
    }

    private fun ResultSet.extractValues() =
        Clothes(
            getInt("id"),
            getString("type"),
            getString("category"),
            getString("brand"),
            getString("color"),
            getString("size")
        )

    private fun collectValues(resultSet: ResultSet): List<Clothes> {
        val resultList = mutableListOf<Clothes>()
        while (resultSet.next()) {
            resultList.add(resultSet.extractValues())
        }
        return resultList
    }
}*/