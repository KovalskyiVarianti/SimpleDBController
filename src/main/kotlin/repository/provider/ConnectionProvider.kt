package repository.provider

import java.sql.Connection

interface ConnectionProvider {
    fun getConnection() :Connection
}
