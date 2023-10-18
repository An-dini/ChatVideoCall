//package com.example.latihan
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.latihan.databinding.FragmentTransactionHistoryBinding
//import com.example.latihan.databinding.HistoryConsultationListBinding
//
//class TransactionListAdapter(private val transactions: List<Transaction>, private val clickListener: TransactionClickListener)
//: RecyclerView.Adapter<Holder>()
//{
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder
//    {
//        val from = LayoutInflater.from(parent.context)
//        val binding = HistoryConsultationListBinding.inflate(from, parent, false)
//        return Holder(binding, clickListener)
//    }
//
//    override fun onBindViewHolder(holder: Holder, position: Int)
//    {
//        holder.bindTransaction(transactions[position])
//    }
//
////    override fun getItemCount(): Int = transactions.size
////
////}
//
//

package com.example.latihan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latihan.databinding.HistoryConsultationListBinding
import java.text.NumberFormat
import java.util.Locale

class TransactionListAdapter(private val transaction: List<Transaction>, private val clickListener: TransactionClickListener) :
    RecyclerView.Adapter<TransactionListAdapter.ViewHolder>()
{
    class ViewHolder(val binding: HistoryConsultationListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val binding = HistoryConsultationListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = transaction.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        with(holder){
            with(transaction[position]){
                val formattedPrice = NumberFormat.getNumberInstance(Locale("id", "ID")).format(this.price)
                val transactionDescription = "Pembayaran via ${this.paymentMethod} sebesar Rp$formattedPrice"


                binding.tvDate.text = this.date
                binding.tvTime.text = this.time
                binding.tvPayment.text = transactionDescription

                binding.clTransaction.setOnClickListener {
                    clickListener.onClick(this)
                }
            }
        }
    }
}
