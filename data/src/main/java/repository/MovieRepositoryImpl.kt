package repository

import android.content.Context
import api.MockApi
import com.globo.domain.model.Movie
import com.globo.domain.repository.MovieRepository
import db.FavoritesRoomDatabase
import io.reactivex.Single
import mapper.MovieMapper
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val mockApi : MockApi,
    private val movieMapper: MovieMapper,
    private val context: Context
) : MovieRepository {

    override fun getAllMovies(): Single<List<Movie>> {
        return mockApi.getAllMovies().map { movieMapper.map(it) }
    }

    override suspend fun insertFavorite(movie : Movie) {
        FavoritesRoomDatabase.getDatabase(context).favoritesDao().insert(movie)
    }

    override suspend fun getFavorites(): List<Movie> {
        return FavoritesRoomDatabase.getDatabase(context).favoritesDao().getFavorites()
    }


}