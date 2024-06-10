package belajar.android.kicaumania.explore

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import belajar.android.kicaumania.R
import belajar.android.kicaumania.databinding.FragmentExploreBinding

class ExploreFragment : Fragment() {

    companion object {
        fun newInstance(): ExploreFragment {
            val fragment = ExploreFragment()
            fragment.arguments = Bundle()
            return fragment
        }
    }

    private lateinit var binding: FragmentExploreBinding
    private val viewModel: ExploreViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}