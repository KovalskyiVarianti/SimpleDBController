package repository

import entities.TestEntity
import specification.Specification
import java.sql.DriverManager
import java.sql.SQLException

class TestRepo(private val connectionProvider: ConnectionProvider) : Repository<TestEntity> {
    override fun add(item: TestEntity) {
        TODO("Not yet implemented")
    }

    override fun remove(specification: Specification) {
        TODO("Not yet implemented")
    }

    override fun query(specification: Specification): List<TestEntity> {
        val con = connectionProvider.getConnection()
        return emptyList()
    }
}