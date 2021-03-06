package repository.provider

import java.sql.*

class SqlConnectionProvider(
    private val ip: String = "127.0.0.1",
    private val port: String = "3306",
    private val user: String = "root",
    private val password: String = "1243",
    private val dbName: String
) : ConnectionProvider {
    override fun getConnection(): Connection =
        DriverManager.getConnection(
            "jdbc:mysql://$ip:$port/$dbName",
            user, password
        )
}
