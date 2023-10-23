package com.example.attendancesystemandroid.utils

import android.widget.Toast
import com.example.attendancesystemandroid.App

fun String.showToast(duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(App.context,this,duration).show()
}

fun Int.showToast(duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(App.context,this,duration).show()
}