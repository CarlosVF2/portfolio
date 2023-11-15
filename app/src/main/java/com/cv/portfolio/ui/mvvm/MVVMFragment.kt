package com.cv.portfolio.ui.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cv.portfolio.R
import com.cv.portfolio.databinding.FragmentMvvmBinding
import com.google.android.material.textfield.TextInputLayout

/**
 * Fragment that will have all the basic comunication with a model that will change the value in a counter
 */
class MVVMFragment : Fragment() {

    /**
     * Binding of the fragment to obtains later the controls
     */
    private var fragmentMvvmBinding: FragmentMvvmBinding? = null

    /**
     * Make the get to always that get the binding in case that is null throws an exception
     */
    private val binding get() = fragmentMvvmBinding ?: throw Exception(getString(R.string.exception_binding_null))

    /**
     * That is scoped to the Activity. When multiple fragments use the same code, they are requesting ViewModels scoped to the parent Activity. If the parent Activity for all the Fragments is the same, the Fragments will get the same ViewModel since the ViewModelStoreOwner connected to the Activity remains the same.
     */
    private val model : MVVMViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        fragmentMvvmBinding = FragmentMvvmBinding.inflate(inflater, container, false)

        val textViewChangeText: TextView = binding.textViewChangeText
        val textInputLayoutChangeText: TextInputLayout = binding.textInputLayoutFieldChangeText
        val buttonChangeText: Button = binding.buttonChangeText
        buttonChangeText.setOnClickListener {
            model.changeText(textInputLayoutChangeText.editText?.text.toString())
        }
        model.text.observe(viewLifecycleOwner) {
            textViewChangeText.text = model.text.value
        }
        val buttonNavigateDetail : Button = binding.buttonNavigateDetail
        buttonNavigateDetail.setOnClickListener{
            findNavController().navigate(R.id.action_nav_mvvm_to_nav_detail_mvvm)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentMvvmBinding = null
    }
}