package dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.globo.domain.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table WHERE user = :user AND password = :password")
    fun getUser(user : String, password : String) : User

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user : User) : Long

}