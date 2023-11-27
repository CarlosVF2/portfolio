package com.cv.portfolio.ui.room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cv.portfolio.databinding.FragmentRoomBinding
import com.cv.portfolio.ui.room.db.entities.Note
import dagger.hilt.android.AndroidEntryPoint

/**
 * View (fragment) of the room database with MVVM architecture and coroutines kotlin
 */
@AndroidEntryPoint
class RoomFragment : Fragment() {

    private var _binding: FragmentRoomBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val noteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        val list = noteViewModel.getAllNotes()
        _binding = FragmentRoomBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textGallery
        //noteViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
        //}
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}