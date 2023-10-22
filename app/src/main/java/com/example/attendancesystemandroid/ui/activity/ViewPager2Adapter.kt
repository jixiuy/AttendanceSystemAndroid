package com.example.attendancesystemandroid.ui.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPager2Adapter(fragments: MutableList<Fragment>, fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragments = fragments
    override fun getItemCount() = fragments.size
    override fun createFragment(position: Int) = fragments[position]
}