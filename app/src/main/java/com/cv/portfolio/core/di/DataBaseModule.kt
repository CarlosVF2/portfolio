package com.cv.portfolio.core.di

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Room
import com.cv.portfolio.ui.room.db.NoteDatabase
import com.cv.portfolio.ui.room.db.dao.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Module to provides the instance of the database
 * Is defined as singleton for all of the life of the application
 */
@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    /**
     * Provides the dao to interact with it
     * @param noteDatabase Database that is inject
     */
    @Provides
    fun providesNotesDao(noteDatabase: NoteDatabase) : NoteDao {
        return noteDatabase.getNoteDao()
    }

    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context) : NoteDatabase{
        return Room.databaseBuilder(context, NoteDatabase::class.java, "NoteDatabase").build()
    }
}