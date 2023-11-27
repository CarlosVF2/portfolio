package com.cv.portfolio.ui.room

import androidx.lifecycle.ViewModel
import com.cv.portfolio.ui.room.db.entities.Note
import com.cv.portfolio.ui.room.repository.NoteRepository

/**
 * View model for the note and view of RoomFragment
 */
class NoteViewModel(
    /**
     * Repository to obtains the data
     */
    private val repository: NoteRepository
): ViewModel() {

    /**
     * Insert the note in the repository
     * @param note note to insert
     */
    suspend fun insertNote(note: Note) = repository.insertNote(note)

    /**
     * Update the note in the repository
     * @param note note to update
     */
    suspend fun updateNote(note: Note) = repository.updateNote(note)

    /**
     * Delete the note in the repository
     * @param note note to delete
     */
    suspend fun deleteNote(note: Note) = repository.deleteNote(note)

    /**
     * Delete the note in the repositoy by the id
     * @param id id to find the note and delete it
     */
    suspend fun deleteNoteById(id: Int) = repository.deleteNoteById(id)

    /**
     * Delete all notes in the repositoty
     */
    suspend fun clearNotes() = repository.clearNotes()

    /**
     * Get all the notes of the repository
     * @return All the notes in the repository
     */
    fun getAllNotes() = repository.getAllNotes()
}