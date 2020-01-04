package com.mockhelper.organizer

import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mockhelper.organizer.databinding.ActivityMainBinding


class CalenderActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}
