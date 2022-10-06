package com.demo.nisaardiyanti
//nama packages
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.demo.nisaardiyanti.db.RoomAppDb
import com.demo.nisaardiyanti.db.UserEntity
//kelas MainActivityViewModel
class MainActivityViewModel(app: Application): AndroidViewModel(app) {
    lateinit var allUsers : MutableLiveData<List<UserEntity>>

    init{
        allUsers = MutableLiveData()
        getAllUsers()
    }
    ////inisiasi dari allusers

    fun getAllUsersObservers(): MutableLiveData<List<UserEntity>> {
        return allUsers
    }
    // funtion untuk mengembalikan allusers

    fun getAllUsers() {
        val userDao = RoomAppDb.getAppDatabase((getApplication()))?.userDao()
        val list = userDao?.getAllUserInfo()
//funtion getAllUsers terdiri  dari val userDao dengan data berasal dari RoomAppDb.getAppDatabase dan val list mengambil dari getUserInfo
        allUsers.postValue(list)
    }

    fun insertUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase(getApplication())?.userDao()
        userDao?.insertUser(entity)
        getAllUsers()
    }
    //funtion menambahkan userinfo dengan val userDao dari data RoomAppDatabase

    fun updateUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase(getApplication())?.userDao()
        userDao?.updateUser(entity)
        getAllUsers()
    }

    fun deleteUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase(getApplication())?.userDao()
        userDao?.deleteUser(entity)
        getAllUsers()
    }
}
