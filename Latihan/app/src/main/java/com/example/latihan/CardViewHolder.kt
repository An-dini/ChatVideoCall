package com.example.latihan

import androidx.recyclerview.widget.RecyclerView
import com.example.latihan.databinding.DoctorListItemBinding

class CardViewHolder(
    private val doctorListItemBinding: DoctorListItemBinding,
    private val clickListener: DoctorClickListener
) : RecyclerView.ViewHolder(doctorListItemBinding.root)
{
    fun bindDoctor(doctor: Doctor)
    {
        doctorListItemBinding.cover.setImageResource(doctor.photo)
        doctorListItemBinding.title.text = doctor.name
        doctorListItemBinding.author.text = doctor.instance

        doctorListItemBinding.cardView.setOnClickListener{
            clickListener.onClick(doctor)
        }
    }
}


