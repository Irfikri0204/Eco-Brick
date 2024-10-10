package com.project.ecobrick.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.project.ecobrick.main.MainActivity
import com.project.ecobrick.R
import com.project.ecobrick.data.PageData
import com.project.ecobrick.databinding.ActivityOnboardingBinding
import com.project.ecobrick.utils.gone
import com.project.ecobrick.utils.visible

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding

    private val onBoardingPageChangeCallback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            when(position){
                0 -> {
                    binding.btnSkip.text = "Skip"
                    binding.btnLanjut.text = "Lanjutkan"
                    binding.btnSkip.visible()
                    binding.btnLanjut.visible()
                }

                1 -> {
                    binding.btnSkip.text = "Skip"
                    binding.btnLanjut.text = "Lanjutkan"
                    binding.btnSkip.visible()
                    binding.btnLanjut.visible()
                }
                else -> {
                    binding.btnLanjut.text = "Mulai"
                    binding.btnSkip.gone()
                    binding.btnLanjut.visible()
                }
            }
        }
    }

    private val pagerList = arrayListOf(
        PageData("Bangun konstruksi dengan penerapan Green Concrete", R.drawable.onboarding1),
        PageData("Memesan bata ringan lebih efisien", R.drawable.onboarding2),
        PageData("Mulailah menggunakan bata ringan yang mendukung penerapan Green Concrete bersama kami",R.drawable.onboarding3)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.vpOnboarding.apply {
            adapter = OnboardingAdapter(this@OnboardingActivity, pagerList)
            registerOnPageChangeCallback(onBoardingPageChangeCallback)
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        TabLayoutMediator(binding.tabLayout, binding.vpOnboarding){tab, position -> }.attach()

        binding.btnLanjut.setOnClickListener {
            if(binding.vpOnboarding.currentItem < binding.vpOnboarding.adapter!!.itemCount - 1){
                binding.vpOnboarding.currentItem += 1
            } else {
                homeScreenIntent()
            }
        }

        binding.btnSkip.setOnClickListener {
            homeScreenIntent()
        }
    }

    override fun onDestroy() {
        binding.vpOnboarding.registerOnPageChangeCallback(onBoardingPageChangeCallback)
        super.onDestroy()
    }
    fun homeScreenIntent(){
        val homeIntent = Intent(this, MainActivity::class.java)
        startActivity(homeIntent)
    }
}