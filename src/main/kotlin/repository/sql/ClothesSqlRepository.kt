package repository.sql

import entities.Clothes
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

    override fun add(item: Clothes) {
        execute(InsertClothesSqlSpecification(item))
    }

    override fun remove(id: Int) {
        execute(DeleteClothesByIdSqlSpecification(id))
    }

    override fun update(item: Clothes) {
        execute(UpdateClothesSqlSpecification(item))
    }

    override fun showAll(): List<Clothes> =
        collectValues(executeQuery(SelectAllClothesSqlSpecification()))

    override fun <S : Specification> query(specification: S) {
        execute(castToSqlSpec(specification))
    }

    override fun <S : ReturnableSpecification> query(returnableSpecification: S): List<Clothes> {
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
}