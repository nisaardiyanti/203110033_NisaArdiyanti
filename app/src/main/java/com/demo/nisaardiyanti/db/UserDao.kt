package com.demo.nisaardiyanti.db
//nama packages
import androidx.room.*

@Dao
interface UserDao {


    @Query("SELECT * FROM userinfo ORDER BY id DESC")
    fun getAllUserInfo(): List<UserEntity>?
//menampilkan data dari userinfo

    @Insert
    fun insertUser(user: UserEntity?)
//funtion insertuser
    @Delete
    fun deleteUser(user: UserEntity?)
//function deleteuser
    @Update
    fun updateUser(user: UserEntity?)
//function updateuser
}
