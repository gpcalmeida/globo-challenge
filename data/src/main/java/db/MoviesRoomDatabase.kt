package db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.globo.domain.model.Movie
import com.globo.domain.model.User
import dao.FavoritesDao
import dao.UserDao

@Database(entities = [Movie::class, User::class], version = 1, exportSchema = false)
abstract class MoviesRoomDatabase : RoomDatabase() {

    abstract fun favoritesDao(): FavoritesDao
    abstract fun userDao() : UserDao

    companion object {
        @Volatile
        private var INSTANCE: MoviesRoomDatabase? = null

        fun getDatabase(context: Context): MoviesRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MoviesRoomDatabase::class.java,
                    "movies_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}