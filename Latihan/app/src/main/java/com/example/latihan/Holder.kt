//package com.example.latihan
//
//import androidx.recyclerview.widget.RecyclerView
//import com.example.latihan.databinding.HistoryConsultationListBinding
//import java.text.NumberFormat
//import java.util.Locale
//
//class Holder (
//    private val transactionListBinding: HistoryConsultationListBinding,
//    private val clickListener: TransactionClickListener
//) : RecyclerView.ViewHolder(transactionListBinding.root)
//{
//    fun bindTransaction(transaction: Transaction)
//    {
//        val formattedPrice = NumberFormat.getNumberInstance(Locale("id", "ID")).format(transaction.price)
//        val transactionDescription = "Pembayaran via ${transaction.paymentMethod} sebesar Rp$formattedPrice"
//
//        transactionListBinding.tvDate.text = transaction.date
//        transactionListBinding.tvTime.text = transaction.time
//        transactionListBinding.tvPayment.text = transactionDescription
//
//
//        transactionListBinding.clTransaction.setOnClickListener{
//            clickListener.onClick(this)
//        }
//    }
//}
//
