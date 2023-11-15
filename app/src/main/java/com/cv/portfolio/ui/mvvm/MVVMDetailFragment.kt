package com.cv.portfolio.ui.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.cv.portfolio.R
import com.cv.portfolio.databinding.FragmentDetailMvvmBinding

/**
 * Fragment to represent the text modified before in Mvvm
 */
class MVVMDetailFragment : Fragment() {

    /**
     * Binding of the fragment to obtains later the controls
     */
    private var fragmentMvvmDetailBinding: FragmentDetailMvvmBinding? = null

    /**
     * Make the get to always that get the binding in case that is null throws an exception
     */
    private val binding get() = fragmentMvvmDetailBinding ?: throw Exception(getString(R.string.exception_binding_null))

    /**
     * That is scoped to the Activity. When multiple fragments use the same code, they are requesting ViewModels scoped to the parent Activity. If the parent Activity for all the Fragments is the same, the Fragments will get the same ViewModel since the ViewModelStoreOwner connected to the Activity remains the same.
     */
    private val model : MVVMViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMvvmDetailBinding = FragmentDetailMvvmBinding.inflate(inflater, container, false)
        val textViewDetailText: TextView = binding.textViewDetailText
        model.text.observe(viewLifecycleOwner) {
            textViewDetailText.text = model.text.value
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentMvvmDetailBinding = null
    }
}