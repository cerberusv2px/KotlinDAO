package entity

data class Employee(var id: Int, var firstname: String, var lastname: String, var email: String, var branch: Branch?) {

    constructor() : this(0, "", "", "", null)

}
