package com.cv.portfolio.ui.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cv.portfolio.ui.room.db.dao.NoteDao
import com.cv.portfolio.ui.room.db.entities.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)

/**
 * Database for notes instance to operate with it
 */
abstract class NoteDatabase: RoomDatabase() {

    /**
     * Dao to make thw queries
     */
    abstract fun getNoteDao(): NoteDao

    companion object {
        private const val DB_NAME = "note_database.db"
        @Volatile private var instance: NoteDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            DB_NAME
        ).build()
    }
}