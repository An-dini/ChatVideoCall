package com.example.latihan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihan.databinding.ActivityMainBinding
import java.io.Serializable

class MainActivity : AppCompatActivity(), DoctorClickListener
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populateDoctors()

        val mainActivity = this
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(applicationContext, 3)
            adapter = DoctorListAdapter(doctorList, mainActivity)
        }
    }
    override fun onClick(doctor: Doctor)
    {
        val intent = Intent(applicationContext, DoctorDetailActivity::class.java)
        intent.putExtra(DOCTOR_ID_EXTRA, doctor.id)
        startActivity(intent)
    }

    private fun populateDoctors()
    {
        val doctor1 = Doctor(
            R.drawable.aji,
            "Drh. Aji",
            "OJ Pet Care",
            "130.000",
            listOf("08:00-15:00", "19:00-22:00"),
            40,
            4.5F
        )
        doctorList.add(doctor1)

        val doctor2 = Doctor(
            R.drawable.mutiara,
            "Drh. Mutiara",
            "OJ Pet Care",
            "130.000",
            listOf("08:00-15:00"),
            40,
            3.5F
        )
        doctorList.add(doctor2)

        val doctor3 = Doctor(
            R.drawable.chandra,
            "Drh. Chandra",
            "BVC Clinic",
            "130.000",
            listOf("08:00-15:00", "19:00-22:00"),
            40,
            5.0F
        )
        doctorList.add(doctor3)

        val doctor4 = Doctor(
            R.drawable.nadine,
            "Drh. Nadine",
            "Canopy Clinic",
            "130.000",
            listOf("08:00-15:00", "19:00-22:00"),
            40,
            5.0F
        )
        doctorList.add(doctor4)

        val doctor5 = Doctor(
            R.drawable.caroline,
            "Drh. Caroline",
            "Amor Clinic",
            "130.000",
            listOf("08:00-15:00"),
            40,
            5.0F
        )
        doctorList.add(doctor5)

        val doctor6 = Doctor(
            R.drawable.julia,
            "Drh. Julia",
            "Groovy Vet",
            "130.000",
            listOf("08:00-15:00", "19:00-22:00"),
            40,
            4.7F
        )
        doctorList.add(doctor6)

        val doctor7 = Doctor(
            R.drawable.aisha,
            "Drh. Aisha",
            "Ciyo Pet Care",
            "130.000",
            listOf("08:00-15:00", "19:00-22:00"),
            40,
            4.9F
        )
        doctorList.add(doctor7)

        val doctor8 = Doctor(
            R.drawable.nalend,
            "Drh. Nalend",
            "Gloriouz Pet",
            "130.000",
            listOf("08:00-15:00"),
            40,
            3.5F
        )
        doctorList.add(doctor8)

        val doctor9 = Doctor(
            R.drawable.lisa,
            "Drh. Isa",
            "Puskeswan Batam",
            "130.000",
            listOf("08:00-15:00", "19:00-22:00"),
            40,
            3.5F
        )
        doctorList.add(doctor9)


        doctorList.add(doctor1)
        doctorList.add(doctor2)
        doctorList.add(doctor3)
        doctorList.add(doctor4)
        doctorList.add(doctor5)
        doctorList.add(doctor6)
        doctorList.add(doctor7)
        doctorList.add(doctor8)
        doctorList.add(doctor9)

    }


}



