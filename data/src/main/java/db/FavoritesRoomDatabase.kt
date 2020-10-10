package db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.globo.domain.model.Movie
import dao.FavoritesDao
import javax.inject.Inject

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class FavoritesRoomDatabase : RoomDatabase() {

    abstract fun favoritesDao(): FavoritesDao

    companion object {
        @Volatile
        private var INSTANCE: FavoritesRoomDatabase? = null

        fun getDatabase(context: Context): FavoritesRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavoritesRoomDatabase::class.java,
                    "favorites_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}