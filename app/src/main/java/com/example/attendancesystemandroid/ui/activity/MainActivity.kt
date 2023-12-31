@file:Suppress("DEPRECATION")

package com.example.attendancesystemandroid.ui.activity

import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.viewpager2.widget.ViewPager2
import com.example.attendancesystemandroid.R
import com.example.attendancesystemandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTransparentStatusBar(this)

        val adapter = binding?.viewPager2?.let { ViewPager2Adapter(this) }
        binding.viewPager2.adapter = adapter

        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> binding.viewPager2.setCurrentItem(0, true)
                R.id.sort -> binding.viewPager2.setCurrentItem(1, true)
                R.id.record -> binding.viewPager2.setCurrentItem(2, true)
                R.id.mine -> binding.viewPager2.setCurrentItem(3, true)
            }
            true
        }

        binding.viewPager2.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomNavView.menu.getItem(position).isChecked = true
            }
        })
    }

    private fun setTransparentStatusBar(activity: Activity) {
        val window = activity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = Color.TRANSPARENT
    }
}
