package com.example.attendancesystemandroid.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.attendancesystemandroid.R
import com.example.attendancesystemandroid.utils.showToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        "你好".showToast()
    }
}
