package com.example.latihan

import androidx.recyclerview.widget.RecyclerView
import com.example.latihan.databinding.HistoryConsultationListBinding

class Holder (
    private val transactionListBinding: HistoryConsultationListBinding,
    private val clickListener: TransactionClickListener
) : RecyclerView.ViewHolder(transactionListBinding.root)
{
    fun bindTransaction(transaction: Transaction)
    {
        transactionListBinding.tvDate.text = transaction.date
        transactionListBinding.tvTime.text = transaction.time
        transactionListBinding.tvPayment.text = transaction.paymentMethod


        transactionListBinding.clTransaction.setOnClickListener{
            clickListener.onClick(transaction)
        }
    }
}

