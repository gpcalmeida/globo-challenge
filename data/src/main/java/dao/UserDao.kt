package dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.globo.domain.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table WHERE user = :user")
    fun getUser(user : String) : User

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertUser(user : User) : Long

}