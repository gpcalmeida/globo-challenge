package dao

import androidx.room.*
import com.globo.domain.model.Movie

@Dao
interface FavoritesDao {

    @Query("SELECT * from favorite_table WHERE user = :user")
    fun getFavorites(user : String): List<Movie>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: Movie)

    @Delete
    suspend fun delete(movie : Movie)

}