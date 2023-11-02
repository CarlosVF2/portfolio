package com.cv.portfolio.ui.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cv.portfolio.databinding.FragmentMvvmBinding
import com.google.android.material.textfield.TextInputLayout

/**
 * Fragment that will have all the basic comunication with a model that will change the value in a counter
 */
class MVVMFragment : Fragment() {

    private var _binding: FragmentMvvmBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val model =
            ViewModelProvider(this)[MVVMViewModel::class.java]

        _binding = FragmentMvvmBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textViewChangeText: TextView = binding.textViewChangeText
        val textInputLayoutChangeText: TextInputLayout = binding.textInputLayoutFieldChangeText
        val buttonChangeText: Button = binding.buttonChangeText
        buttonChangeText.setOnClickListener {
            model.changeText(textInputLayoutChangeText.editText?.text.toString())
        }
        model.text.observe(viewLifecycleOwner) {
            textViewChangeText.text = model.text.value
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}