package main

import dao.BranchDAO
import dao.EmployeeDAO
import dao.StudentDAO
import dao.impl.BranchDAOImpl
import dao.impl.EmployeeDAOImpl
import dao.impl.StudentDAOImpl
import entity.Branch
import entity.Employee
import entity.Student
import java.util.*


fun main(args: Array<String>) {
    /*var stdDAO : StudentDAO = StudentDAOImpl()
    var stdList : MutableList<Student> = ArrayList<Student>()
    stdList.add(Student(1,"Sujin","Shrestha",21))
    stdList.add(Student(2,"Sonika","Shrstha",22))
    stdList.add(Student(3,"Sudeep","Bajracharya",22))

    for(std in stdList){
        stdDAO.insert(std)
    }

    println("Number of all students")
    println(stdDAO.getAll().size)

    var students : List<Student> = stdDAO.getAll()
    for(s in students){
        println(s)
    }


    var std1 : Student = stdDAO.getById(1) as Student
    println(std1)*/


    var branchDAO: BranchDAO = BranchDAOImpl()
    // branchDAO.insert(Branch(1,"Mustang"))

    /* var branchList : ArrayList<Branch> = branchDAO.getAll() as ArrayList<Branch>
     for(b in branchList){
         println(b)
     }*/
    var b: Branch = branchDAO.getById(1)


    var empDAO: EmployeeDAO = EmployeeDAOImpl()
    empDAO.insert(Employee(2, "Sonika", "Shrestha", "soni@gmail.com", b))
    var empList: ArrayList<Employee> = empDAO.getAll() as ArrayList<Employee>
    for (e in empList) {
        println(e)
    }


}

