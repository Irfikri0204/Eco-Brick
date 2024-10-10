package com.project.ecobrick.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.project.ecobrick.data.PageData

class OnboardingAdapter (activity: FragmentActivity, private val pagerList : ArrayList<PageData>) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = pagerList.size

    override fun createFragment(position: Int): Fragment {
        return OnboardingFragment(pagerList[position])
    }
}