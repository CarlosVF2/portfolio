package com.cv.portfolio.core.factories

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cv.portfolio.ui.room.repository.NoteRepository

/**
 * ViewModelFactory for the object of Notes that need the repository to obtains data
 * @param repository repository to interact with the data
 */
class NoteViewModelFactory(
    private val repository: NoteRepository
) : ViewModelProvider.NewInstanceFactory() {

     override fun <T : ViewModel> create(modelClass: Class<T>): T {
        try {
            val constructor = modelClass.getDeclaredConstructor(NoteRepository::class.java)
            return constructor.newInstance(repository)
        } catch (e: Exception) {
            Log.d("NoteViewModelFactor", e.message.toString())
        }
        return super.create(modelClass)
    }
}