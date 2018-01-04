package dao.impl

import dao.BranchDAO
import dao.EmployeeDAO
import entity.Branch
import entity.Employee
import util.DBConnection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.*

public class EmployeeDAOImpl : EmployeeDAO {

    var conn: DBConnection = DBConnection()
    var branchDAO: BranchDAO = BranchDAOImpl()

    override fun insert(employee: Employee) {
        conn.open()


        var sql: String = "INSERT INTO employee VALUES(?,?,?,?,?)"
        var stmt: PreparedStatement = conn.initStatement(sql);
        stmt.setInt(1, employee.id)
        stmt.setString(2, employee.firstname)
        stmt.setString(3, employee.lastname)
        stmt.setString(4, employee.email)
        stmt.setInt(5, employee.branch?.id as Int)

        conn.executeUpdate()
        conn.close()
    }

    override fun update(t: Employee) {
        throw UnsupportedOperationException()
    }

    override fun getAll(): List<Employee> {
        conn.open()

        var sql: String = "SELECT * FROM employee"
        var stmt: PreparedStatement = conn.initStatement(sql)
        var result: ResultSet? = conn.executeQuery()
        var empList: MutableList<Employee> = ArrayList<Employee>()
        while (result?.next() as Boolean) {
            var branch: Branch = branchDAO.getById(result?.getInt("bid") as Int)
            empList.add(Employee(
                    result?.getInt("id") as Int,
                    result?.getString("firstname") as String,
                    result?.getString("lastname") as String,
                    result?.getString("email") as String,
                    branch))
        }
        conn.close()
        return empList
    }

    override fun getById(id: Int): Employee {
        conn.open()
        var sql: String = "SELECT * from employee where id=?"
        var stmt = conn.initStatement(sql)
        stmt.setInt(1, id)
        var result = conn.executeQuery()
        var emp: Employee = Employee()
        while (result?.next() as Boolean) {
            var branch = branchDAO.getById(result?.getInt("bid") as Int)
            emp.id = result?.getInt("id") as Int
            emp.firstname = result?.getString("firstname") as String
            emp.lastname = result?.getString("lastname") as String
            emp.email = result?.getString("email") as String
            emp.branch = branch
        }
        conn.close()
        return emp
    }

}