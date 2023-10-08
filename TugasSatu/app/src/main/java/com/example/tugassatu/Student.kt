package com.example.tugassatu

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class Student(
    val name: String,
    val npm: String,
    val uts: Double,
    val uas: Double
):Parcelable
