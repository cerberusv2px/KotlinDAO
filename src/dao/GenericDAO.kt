package dao

import java.sql.ResultSet

public interface GenericDAO<T>{

    public fun insert(t : T)
    public fun update(t : T)
    public fun getAll() : List<T>
    public fun getById(id : Int) : T

}
