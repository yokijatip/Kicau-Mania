package belajar.android.kicaumania.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import belajar.android.kicaumania.databinding.FragmentHomeBinding
import belajar.android.kicaumania.home.camera.CameraActivity

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            fragment.arguments = Bundle()
            return fragment
        }
    }

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            val fiturBelumTersedia = "Fitur belum tersedia Boss...😞"

            btnSearch.setOnClickListener {
                Toast.makeText(requireContext(), fiturBelumTersedia, Toast.LENGTH_SHORT).show()
            }

            btnShoppingBag.setOnClickListener {
                Toast.makeText(requireContext(), fiturBelumTersedia, Toast.LENGTH_SHORT).show()
            }

            btnProfile.setOnClickListener {
                Toast.makeText(requireContext(), fiturBelumTersedia, Toast.LENGTH_SHORT).show()
            }

            menuCamera.setOnClickListener {
                startActivity(Intent(requireContext(), CameraActivity::class.java))
            }
        }
    }
}