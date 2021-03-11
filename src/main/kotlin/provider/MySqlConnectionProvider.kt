package provider

import java.sql.*

class MySqlConnectionProvider(
    private var dbName: String,
    private val ip: String = "127.0.0.1",
    private val port: String = "3306",
    private val user: String = "root",
    private val password: String = "1243"
) : ConnectionProvider {
    override fun getConnection(): Connection =
        try {
            DriverManager.getConnection(
                "jdbc:mysql://$ip:$port/$dbName",
                user, password
            )
        } catch (sqlException : SQLSyntaxErrorException){
            println("Cannot find database. Please input name of existing one:")
            dbName = "${readLine()}"
            getConnection()
        }
}
