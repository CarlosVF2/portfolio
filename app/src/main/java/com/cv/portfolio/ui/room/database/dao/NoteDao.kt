package com.cv.portfolio.ui.room.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cv.portfolio.ui.room.database.entities.Note

/**
 * Interface of the Note entity to make all the queries and use the database
 */
@Dao
interface NoteDao {
    /**
     * Insert the note in the database (in case of conflict will replace the before data with the new one)
     * @param note Note to insert
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    /**
     * Update the note in database
     * @param note update the note (will update by the ID)
     */
    @Update
    suspend fun updateNote(note: Note)

    /**
     * Delete the note in database
     * @param note delete note (will delete by id)
     */
    @Delete
    suspend fun deleteNote(note: Note)

    /**
     * Obtains all the notes in database (LiveData is in other thread, not necessary suspend)
     * @return All the notes in database
     */
    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("DELETE FROM note_table")
    suspend fun clearNotes()

    @Query("DELETE FROM note_table WHERE id = :id")
    suspend fun deleteNoteById(id: Int)
}
