package com.example.latihan

var doctorList = mutableListOf<Doctor>()

val DOCTOR_ID_EXTRA = "doctorExtra"

class Doctor(
    var photo: Int,
    var name: String,
    var instance: String,
    var price: String,
    var schedule: String,
    var duration: String,
    var rating: Float,
    val id: Int? = doctorList.size
)





