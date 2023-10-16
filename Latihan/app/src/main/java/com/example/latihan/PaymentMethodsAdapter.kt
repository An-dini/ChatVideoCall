package com.example.latihan

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class PaymentMethodsAdapter(private val paymentMethods: List<PaymentMethodModel>) :
    RecyclerView.Adapter<PaymentMethodsAdapter.PaymentMethodViewHolder>() {

    private var isExpanded = false // To track whether the list should be expanded

    // Check whether to display all items or only the first 5 items
    private val displayedItemCount = if (isExpanded) paymentMethods.size else 5

    class PaymentMethodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val paymentMethodLogo: ImageView = itemView.findViewById(R.id.paymentMethodLogo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentMethodViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.payment_list_mitra, parent, false)
        return PaymentMethodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PaymentMethodViewHolder, position: Int) {
        val currentItem = paymentMethods[position]
        holder.paymentMethodLogo.setImageResource(currentItem.logoResource)
    }

    override fun getItemCount(): Int {
        return displayedItemCount
    }

    // Method to add more items to the list when "lihat selengkapnya" is clicked
    @SuppressLint("NotifyDataSetChanged")
    fun expandList() {
        isExpanded = true
        notifyDataSetChanged()
    }
}

