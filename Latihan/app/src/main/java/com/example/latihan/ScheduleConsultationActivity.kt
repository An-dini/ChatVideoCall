package com.example.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class ScheduleConsultationActivity : AppCompatActivity() {
    private lateinit var dateRecyclerView: RecyclerView
    private val dateList = ArrayList<DateModel>()
    private lateinit var btSchedule: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_consultation)

        dateRecyclerView = findViewById(R.id.dateRecyclerView)
        dateRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Inisialisasi daftar tanggal
        val dateCalendar = Calendar.getInstance()
        for (i in 0 until 4) {
            dateList.add(
                DateModel(
                    SimpleDateFormat("dd", Locale.getDefault()).format(dateCalendar.time),
                    SimpleDateFormat("E", Locale.getDefault()).format(dateCalendar.time)
                )
            )
            dateCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        // Inisialisasi adapter dan atur RecyclerView untuk tanggal
        val dateAdapter = DateAdapter(dateList)
        dateRecyclerView.adapter = dateAdapter

        // Mendengarkan tindakan pemilihan tanggal
        dateAdapter.setOnItemClickListener(object : DateAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                // Tindakan saat pengguna memilih tanggal
                val selectedDate = dateList[position]
                // Misalnya, Anda dapat menampilkan tanggal yang dipilih dalam pesan Toast
                showToast("Tanggal dipilih: ${selectedDate.date}")
            }
        })

            // Inisialisasi RecyclerView untuk jam konsultasi pagi
        val timeRecyclerViewPagi: RecyclerView = findViewById(R.id.timeRecyclerView)
        timeRecyclerViewPagi.layoutManager = GridLayoutManager(this, 5)

        // Inisialisasi RecyclerView untuk jam konsultasi siang
        val timeRecyclerViewSiang: RecyclerView = findViewById(R.id.timeRecyclerViewSiang)
        timeRecyclerViewSiang.layoutManager = GridLayoutManager(this, 5)

        // Inisialisasi RecyclerView untuk jam konsultasi sore
        val timeRecyclerViewSore: RecyclerView = findViewById(R.id.timeRecyclerViewSore)
        timeRecyclerViewSore.layoutManager = GridLayoutManager(this, 5)

        // Inisialisasi RecyclerView untuk jam konsultasi malam
        val timeRecyclerViewMalam: RecyclerView = findViewById(R.id.timeRecyclerViewMalam)
        timeRecyclerViewMalam.layoutManager = GridLayoutManager(this, 5)

        // Buat daftar waktu konsultasi untuk pagi, siang, dan malam
        val timeListPagi = mutableListOf<TimeModel>()
        val timeListSiang = mutableListOf<TimeModel>()
        val timeListSore = mutableListOf<TimeModel>()
        val timeListMalam = mutableListOf<TimeModel>()

        val timeCalendar = Calendar.getInstance()
        timeCalendar.set(Calendar.HOUR_OF_DAY, 8) // Mulai dari jam 08:00
        timeCalendar.set(Calendar.MINUTE, 0) // Menit diatur ke 0

        val endCalendarPagi = Calendar.getInstance()
        endCalendarPagi.set(Calendar.HOUR_OF_DAY, 11) // Hingga jam 11:00
        endCalendarPagi.set(Calendar.MINUTE, 0) // Menit diatur ke 0

        val endCalendarSiang = Calendar.getInstance()
        endCalendarSiang.set(Calendar.HOUR_OF_DAY, 14) // Hingga jam 15:00
        endCalendarSiang.set(Calendar.MINUTE, 0) // Menit diatur ke 0

        val endCalendarSore = Calendar.getInstance()
        endCalendarSore.set(Calendar.HOUR_OF_DAY, 19) // Hingga jam 18:00
        endCalendarSore.set(Calendar.MINUTE, 0) // Menit diatur ke 0

        val endCalendarMalam = Calendar.getInstance()
        endCalendarMalam.set(Calendar.HOUR_OF_DAY, 24) // Hingga jam 23:00
        endCalendarMalam.set(Calendar.MINUTE, 0) // Menit diatur ke 0


        while (timeCalendar.before(endCalendarPagi)) {
            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
            val startTime = timeFormat.format(timeCalendar.time)
            timeCalendar.add(Calendar.HOUR_OF_DAY, 1)
            timeListPagi.add(TimeModel("$startTime"))
        }

        while (timeCalendar.before(endCalendarSiang)) {
            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
            val startTime = timeFormat.format(timeCalendar.time)
            timeCalendar.add(Calendar.HOUR_OF_DAY, 1)
            timeListSiang.add(TimeModel("$startTime"))
        }

        while (timeCalendar.before(endCalendarSore)) {
            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
            val startTime = timeFormat.format(timeCalendar.time)
            timeCalendar.add(Calendar.HOUR_OF_DAY, 1)
            timeListSore.add(TimeModel("$startTime"))
        }

        while (timeCalendar.before(endCalendarMalam)) {
            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
            val startTime = timeFormat.format(timeCalendar.time)
            timeCalendar.add(Calendar.HOUR_OF_DAY, 1)
            timeListMalam.add(TimeModel("$startTime"))
        }

        // Inisialisasi adapter dan atur RecyclerView untuk waktu pagi, siang, sore, dan malam
        val timeAdapterPagi = TimeAdapter(timeListPagi)
        timeRecyclerViewPagi.adapter = timeAdapterPagi

        val timeAdapterSiang = TimeAdapter(timeListSiang)
        timeRecyclerViewSiang.adapter = timeAdapterSiang

        val timeAdapterSore = TimeAdapter(timeListSore)
        timeRecyclerViewSore.adapter = timeAdapterSore

        val timeAdapterMalam = TimeAdapter(timeListMalam)
        timeRecyclerViewMalam.adapter = timeAdapterMalam

        // button schedule
        btSchedule = findViewById(R.id.scheduleButton)

        btSchedule.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }

        val backButton = findViewById(R.id.btPrev) as ImageView

        backButton.setOnClickListener {
            onBackPressed()
        }

    }

    // Fungsi untuk menampilkan pesan Toast
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
