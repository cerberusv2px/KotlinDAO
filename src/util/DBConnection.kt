package util

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

class DBConnection {

    private var conn: Connection? = null
    private var stmt: PreparedStatement? = null

    public fun open() {
        Class.forName("com.mysql.jdbc.Driver")
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "sujin")
    }


    public fun initStatement(sql: String): PreparedStatement {
        stmt = conn?.prepareStatement(sql)
        return stmt as PreparedStatement
    }

    public fun executeUpdate(): Int? {
        return stmt?.executeUpdate()
    }

    public fun executeQuery(): ResultSet? {
        return stmt?.executeQuery()
    }

    public fun close() {
        if (conn != null) {
            (conn as Connection).close()
            conn = null
        }
    }

}