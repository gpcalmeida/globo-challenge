package com.globo.data

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.globo.domain.model.Movie
import db.MoviesRoomDatabase

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class FavoritesInstrumentedTest {

    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val room = MoviesRoomDatabase.getDatabase(context)

    @Test
    fun should_Insert_Favorite_In_Database() {
        val movie = Movie(
            title = "Star Wars: Episode I",
            subtitle = "The Phantom Menace",
            duration = "2h 16min",
            synopsis = "Two Jedi escape a hostile blockade to find allies and come across a young boy who may bring balance to the Force, but the long dormant Sith resurface to claim their original glory.",
            thumbnail = "https://m.media-amazon.com/images/M/MV5BYTRhNjcwNWQtMGJmMi00NmQyLWE2YzItODVmMTdjNWI0ZDA2XkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_UX182_CR0,0,182,268_AL_.jpg",
            user = "gustavo"
        )
        room.favoritesDao().insert(movie)
        val favorite = room.favoritesDao().getFavorites("gustavo")
        assertTrue(favorite.isNotEmpty())
    }

    @Test
    fun should_Get_Favorite_From_Database() {
        val user = "gustavo"
        val favorite = room.favoritesDao().getFavorites(user)
        assertEquals(favorite, 1)
    }

    @Test
    fun should_Delete_Favorite_From_Database() {
        val movie = Movie(
            id = 0,
            title = "",
            subtitle = "",
            duration = "",
            synopsis = "",
            thumbnail = "",
            user = "gustavo"
        )
        val hasDeleted = room.favoritesDao().delete(movie)
        assertNotNull(hasDeleted)
    }


}