package com.project.ecobrick.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.ecobrick.R
import com.project.ecobrick.databinding.FragmentHomeBinding
import com.project.ecobrick.homesection.EcoBrickActivity
import com.project.ecobrick.homesection.PanduanActivity
import com.project.ecobrick.homesection.TentangKamiActivity

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.what.setOnClickListener {
            val intent = Intent(requireContext(), EcoBrickActivity::class.java)
            startActivity(intent)
        }
        binding.tutorial.setOnClickListener {
            val intent = Intent(requireContext(), PanduanActivity::class.java)
            startActivity(intent)
        }

        binding.about.setOnClickListener {
            val intent = Intent(requireContext(), TentangKamiActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}