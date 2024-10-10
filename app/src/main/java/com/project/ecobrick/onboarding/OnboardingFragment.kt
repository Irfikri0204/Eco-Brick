package com.project.ecobrick.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.ecobrick.R
import com.project.ecobrick.data.PageData
import com.project.ecobrick.databinding.FragmentOnboardingBinding

class OnboardingFragment (private val page : PageData) : Fragment() {
    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.ivOnboarding.setImageResource(page.img)
        binding.tvOnboarding.text = page.title

        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}