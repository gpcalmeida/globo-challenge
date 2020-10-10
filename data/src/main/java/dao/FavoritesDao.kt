package dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.globo.domain.model.Movie

@Dao
interface FavoritesDao {

    @Query("SELECT * from favorites_table")
    fun getFavorites(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: Movie)

}