package repository

import entities.Clothes
import repository.provider.ConnectionProvider
import repository.provider.SqlConnectionProvider
import specification.*
import java.sql.ResultSet

class SqlRepository(private val connectionProvider: ConnectionProvider) : Repository<Clothes> {
    override fun add(item: Clothes) {
        connectionProvider.execute(InsertClothesSpecification(item))
    }

    override fun remove(id: Int) {
        connectionProvider.execute(DeleteClothesByIdSpecification(id))
    }

    override fun update(item: Clothes) {
        connectionProvider.execute(UpdateClothesSpecification(item))
    }

    override fun query(returnableSpecification: ReturnableSpecification): List<Clothes> {
        val con = connectionProvider.getConnection()
        val stmt = con.prepareStatement(SelectAllClothesSpecification().castToSqlSpec().toSqlQuery())
        val resultSet = stmt.executeQuery()
        return resultSet.toList()
    }

    private fun ConnectionProvider.execute(sqlSpecification: SqlSpecification) =
        getConnection().prepareStatement(sqlSpecification.toSqlQuery()).execute()

    private fun Specification.castToSqlSpec() = this as SqlSpecification

    private fun ResultSet.toList(): List<Clothes> {
        val resultList = mutableListOf<Clothes>()
        while (this.next()) {
            resultList.add(
                Clothes(
                    this.getInt("id"),
                    this.getString("type"),
                    this.getString("category"),
                    this.getString("brand"),
                    this.getString("color"),
                    this.getString("size")
                )
            )
        }
        return resultList
    }
}

fun main() {
    SqlRepository(SqlConnectionProvider(dbName = "mydb")).query(SelectAllClothesSpecification())
        .forEach { println(it.toString()) }
}