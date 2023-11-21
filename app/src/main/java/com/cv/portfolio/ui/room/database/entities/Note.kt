package com.cv.portfolio.ui.room.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * POJO to save each note of the user
 */
@Entity(tableName = "note_table")
data class Note (
    /**
     * PK of the Note
     */
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    /**
     * Title of the note
     */
    val title: String?,
    /**
     * Description of the note
     */
    val description: String?,
    /**
     * Priority of the Note (TODO make an enum with High, Medium and Low)
     */
    val priority: Int?
)