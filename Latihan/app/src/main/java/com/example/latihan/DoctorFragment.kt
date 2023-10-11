package com.example.latihan


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.latihan.databinding.FragmentDoctorBinding

class DoctorFragment : Fragment(), DoctorClickListener {
    private lateinit var binding: FragmentDoctorBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoctorBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populateDoctors()
        setupRecyclerView()
    }

    override fun onClick(doctor: Doctor) {
        val intent = Intent(requireContext(), DoctorDetailActivity::class.java)
        intent.putExtra(DOCTOR_ID_EXTRA, doctor.id)
        startActivity(intent)
    }
    private fun populateDoctors()
    {
        val doctorNames = resources.getStringArray(R.array.doctor_names)
        val doctorInstances = resources.getStringArray(R.array.doctor_instances)
        val doctorPrice = resources.getString(R.string.doctor_price)
        val doctorSchedule = resources.getString(R.string.doctor_schedule)
        val doctorDuration = resources.getString(R.string.doctor_duration)
        val doctorRating = resources.getStringArray(R.array.doctor_rating)
        val coverList = cover()

        for (i in doctorNames.indices) {
            val doctor = Doctor(
                coverList[i],
                doctorNames[i],
                doctorInstances[i],
                doctorPrice,
                doctorSchedule,
                doctorDuration,
                doctorRating[i].toFloat()
            )
            doctorList.add(doctor)
        }
    }
    private fun cover():List<Int> = listOf(
        R.drawable.aji,
        R.drawable.mutiara,
        R.drawable.chandra,
        R.drawable.nadine,
        R.drawable.caroline,
        R.drawable.julia,
        R.drawable.aisha,
        R.drawable.nalend,
        R.drawable.lisa,
        R.drawable.annisa,
        R.drawable.nabila,
        R.drawable.dion
    )

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = DoctorListAdapter(doctorList, this@DoctorFragment)
        }
    }
}