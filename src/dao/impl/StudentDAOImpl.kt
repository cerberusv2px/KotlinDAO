package dao.impl

import dao.StudentDAO
import entity.Student
import java.util.*

class StudentDAOImpl : StudentDAO {

    var studentList : MutableList<Student> = ArrayList<Student>()

    override fun insert(student: Student) {
        studentList.add(student)
    }

    override fun getAll(): ArrayList<Student> {
        return studentList as ArrayList<Student>
    }

    override fun getById(id: Int): Student? {

        for(s in studentList){
            if(id==s.id){
                return s
            }
        }
        return null
    }

}