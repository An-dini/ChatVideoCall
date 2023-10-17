package com.example.latihan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latihan.databinding.FragmentTransactionHistoryBinding
import com.example.latihan.databinding.HistoryConsultationListBinding

class TransactionListAdapter(private val transactions: List<Transaction>, private val clickListener: TransactionClickListener)
: RecyclerView.Adapter<Holder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder
    {
        val from = LayoutInflater.from(parent.context)
        val binding = HistoryConsultationListBinding.inflate(from, parent, false)
        return Holder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: Holder, position: Int)
    {
        holder.bindTransaction(transactions[position])
    }

    override fun getItemCount(): Int = transactions.size

}


