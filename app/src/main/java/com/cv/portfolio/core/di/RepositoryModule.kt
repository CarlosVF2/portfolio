package com.cv.portfolio.core.di

import com.cv.portfolio.ui.room.db.NoteDatabase
import com.cv.portfolio.ui.room.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.components.SingletonComponent

/**
 * Module to provides all for the repositories that is needed.
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    /**
     * Provider for Note Repository
     * @param noteDatabase Database to interact with it
     */
    @Provides
    fun provideNoteRepository(noteDatabase: NoteDatabase) : NoteRepository {
        return NoteRepository(noteDatabase)
    }

}