package dao

import androidx.room.*
import com.globo.domain.model.Movie

@Dao
interface FavoritesDao {

    @Query("SELECT * from favorite_table WHERE user = :user")
    fun getFavorites(user : String): List<Movie>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(movie: Movie)

    @Delete
    fun delete(movie : Movie)

}