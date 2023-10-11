package com.example.latihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihan.databinding.ActivityDoctorDetailBinding

class DoctorDetailActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDoctorDetailBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val doctorID = intent.getIntExtra(DOCTOR_ID_EXTRA, -1)
        val doctor = doctorFromID(doctorID)
        if(doctor != null)
        {
            binding.cover.setImageResource(doctor.photo)
            binding.price.text = doctor.price
            binding.duration.text = "${doctor.duration} minutes"
            binding.name.text = doctor.name
            binding.instance.text = doctor.instance
            binding.ratingBar.rating = doctor.rating

            val schedules = doctor.schedule
            binding.schedule.text = schedules
        }
    }

    private fun doctorFromID(doctorID: Int): Doctor?
    {
        for(doctor in doctorList)
        {
            if(doctor.id == doctorID)
                return doctor
        }
        return null
    }
}


