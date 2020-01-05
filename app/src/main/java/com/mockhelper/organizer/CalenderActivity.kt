package com.mockhelper.organizer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.CalendarView
import androidx.databinding.DataBindingUtil
import com.mockhelper.organizer.databinding.ActivityMainBinding
import com.mockhelper.organizer.persistense.BlogActivityDao
import com.mockhelper.organizer.persistense.OrganizerDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDate


class CalenderActivity : Activity() {

    private lateinit var binding: ActivityMainBinding
    private var dao: BlogActivityDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dao = OrganizerDatabase.getInstance(this)?.blogActivityDao()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.calendar.setOnDateChangeListener { _, year, month, day ->
            val date = LocalDate.of(year, month+1, day)
            getActivity(date)
        }

    }

    private fun getActivity(date: LocalDate) {
        GlobalScope.launch {
        val activities = dao?.getByDate(date)
        Log.i("Calendar", "$date $activities")
        }
    }

    public fun onAddActivityClicked() {
        val chosenDate = binding.calendar.date
        intent = Intent(this, CreateActivity::class.java)
        intent.putExtra("activityDate", chosenDate)
        startActivity(intent)
    }
}
