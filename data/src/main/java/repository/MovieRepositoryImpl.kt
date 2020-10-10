package repository

import api.MockApi
import com.globo.domain.model.Movie
import com.globo.domain.repository.MoviesRepository
import io.reactivex.Single
import mapper.MovieMapper
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val mockApi : MockApi,
    private val movieMapper: MovieMapper
) : MoviesRepository {

    override fun getAllMovies(): Single<List<Movie>> {
        return mockApi.getAllMovies().map { movieMapper.map(it) }
    }

}