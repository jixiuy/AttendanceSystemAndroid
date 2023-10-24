package com.example.attendancesystemandroid.ui.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.attendancesystemandroid.ui.fragment.Home.HomeFragment
import com.example.attendancesystemandroid.ui.fragment.mine.MineFragment
import com.example.attendancesystemandroid.ui.fragment.record.RecordFragment
import com.example.attendancesystemandroid.ui.fragment.sort.SortMainFragment

class ViewPager2Adapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private var fragments:MutableList<Fragment> = ArrayList()

    init {
        fragments.add(HomeFragment())
        fragments.add(SortMainFragment())
        fragments.add(RecordFragment())
        fragments.add(MineFragment())
    }

    override fun getItemCount() = fragments.size
    override fun createFragment(position: Int) = fragments[position]
}