package com.cv.portfolio.ui.room.repository

import androidx.lifecycle.LiveData
import com.cv.portfolio.ui.room.db.NoteDatabase
import com.cv.portfolio.ui.room.db.entities.Note

/**
 * Repository to obtains the data (could be remote or local, in this case is local in persistance)
 */
class NoteRepository(
    /**
     * Database to interact and obtain the data
     */
    private val noteDatabase: NoteDatabase
) {

    /**
     * Insert the note in database
     * @param note note to insert
     */
    suspend fun insertNote(note: Note) = noteDatabase.getNoteDao().insertNote(note)

    /**
     * Update the note in database
     * @param note note to update
     */
    suspend fun updateNote(note: Note) = noteDatabase.getNoteDao().updateNote(note)

    /**
     * Delete the note in database
     * @param note note to delete
     */
    suspend fun deleteNote(note: Note) = noteDatabase.getNoteDao().deleteNote(note)

    /**
     * Delete the note in database by the ID
     * @param ID of the note to find and delete it
     */
    suspend fun deleteNoteById(id: Int) = noteDatabase.getNoteDao().deleteNoteById(id)

    /**
     * Clear all of the notes in database
     */
    suspend fun clearNotes() = noteDatabase.getNoteDao().clearNotes()

    /**
     * Obtains all of the notes in database
     */
    fun getAllNotes(): LiveData<List<Note>> = noteDatabase.getNoteDao().getAllNotes()
}