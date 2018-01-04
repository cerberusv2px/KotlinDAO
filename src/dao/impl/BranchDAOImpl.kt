package dao.impl

import dao.BranchDAO
import entity.Branch
import util.DBConnection
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.*

/**
 * Created by Sujin on 5/25/2017.
 */

public class BranchDAOImpl : BranchDAO {

    var conn: DBConnection = DBConnection()

    override fun insert(branch: Branch) {
        conn.open()
        var sql: String = "INSERT INTO branch VALUES (?,?)"
        var stmt: PreparedStatement = conn.initStatement(sql)
        stmt.setInt(1, branch.id)
        stmt.setString(2, branch.name)
        conn.executeUpdate()
        conn.close()
    }

    override fun update(t: Branch) {
        throw UnsupportedOperationException()
    }

    override fun getAll(): List<Branch> {
        conn.open()
        var sql: String = "SELECT * FROM branch"
        var stmt: PreparedStatement = conn.initStatement(sql)
        var branchList: MutableList<Branch> = ArrayList<Branch>()
        var result: ResultSet? = conn.executeQuery()
        while (result?.next() as Boolean) {
            var branch = Branch(result?.getInt("id") as Int, result?.getString("location") as String)
            branchList.add(branch)
        }

        conn.close()
        return branchList

    }

    override fun getById(id: Int): Branch {
        conn.open()
        var sql: String = "SELECT * FROM branch WHERE id=?"
        var stmt: PreparedStatement = conn.initStatement(sql)
        stmt.setInt(1, id)
        var result: ResultSet? = conn.executeQuery()
        var branch: Branch = Branch()
        if (result?.next() as Boolean) {
            branch.id = result?.getInt("id") as Int
            branch.name = result?.getString("location") as String
        }
        return branch
    }

}
