package mapper

import com.globo.domain.model.Movie
import response.MovieResponse
import javax.inject.Inject

class MovieMapper @Inject constructor() {

    fun map(response : List<MovieResponse>) : List<Movie> {
        return response.map { map(it) }
    }

    fun map(response : MovieResponse) : Movie {
        return Movie(
            title = response.title,
            subtitle = response.title,
            synopsis = response.synopsis,
            duration = response.duration,
            thumbnail = response.thumbnail
        )
    }
}