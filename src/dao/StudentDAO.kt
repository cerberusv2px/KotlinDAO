package dao

import entity.Student


interface StudentDAO{
    fun insert(student : Student)
    fun getAll() : List<Student>
    fun getById(id : Int): Student?
}
