package com.project.ecobrick.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.ecobrick.R
import com.project.ecobrick.databinding.FragmentProductBinding
import com.project.ecobrick.productsection.DetailActivity
import com.project.ecobrick.productsection.PengenalanActivity


class ProductFragment : Fragment() {
    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.product.setOnClickListener {
            val intent = Intent(activity, DetailActivity::class.java)
            startActivity(intent)
        }

        binding.rincian.setOnClickListener {
            val intent = Intent(activity, PengenalanActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}