package com.example.attendancesystemandroid.ui.fragment.sort

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.attendancesystemandroid.databinding.FragmentSortMainBinding
import com.google.android.material.tabs.TabLayout


class SortMainFragment() : Fragment() {

    private var binding: FragmentSortMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSortMainBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pagerAdapter = activity?.let { ViewPager2Adapter(it) }
        binding?.viewPager?.adapter = pagerAdapter

        binding?.viewPager?.let {
            binding?.tabLayout?.let { it1 ->
                setupViewPagerWithTabLayout(
                    it, it1
                )
            }
        }

    }




    private fun setupViewPagerWithTabLayout(viewPager: ViewPager2, tabLayout: TabLayout) {


        val tab1 = binding?.tabLayout?.newTab()
        tab1?.text = "新人"
        tab1?.let { binding?.tabLayout?.addTab(it) }

        val tab2 = binding?.tabLayout?.newTab()
        tab2?.text = "老人"
        tab2?.let { binding?.tabLayout?.addTab(it) }


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                // Do nothing
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Do nothing
            }
        })

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.getTabAt(position)?.select()
            }
        })
    }

}