package com.example.latihan

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihan.databinding.FragmentTransactionHistoryBinding

class TransactionHistoryFragment : Fragment(), TransactionClickListener {
    private lateinit var binding: FragmentTransactionHistoryBinding
    private val transactionList = mutableListOf<Transaction>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTransactionHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transactions()
        setupRecyclerView()
    }

    override fun onClick(transaction: Transaction) {
        val intent = Intent(requireContext(), HistoryConsultationDetailActivity::class.java)
        intent.putExtra("transactionId", transaction.id)
        startActivity(intent)
    }
    private fun transactions(){
        val doctorName = resources.getStringArray(R.array.doctor_name_trans)
        val doctorInstance = resources.getStringArray(R.array.doctor_instance_trans)
        val priceTrans = resources.getString(R.string.price_trans)
        val ratingTrans = resources.getStringArray(R.array.rating_trans)
        val dateTrans = resources.getStringArray(R.array.date_trans)
        val timeTrans = resources.getStringArray(R.array.time_trans)
        val paymentMethod = resources.getStringArray(R.array.payment_trans)

        for (i in doctorName.indices) {
            val doctor = doctorName[i]
            val transaction = Transaction(
                coverResource(doctor),
                doctor,
                doctorInstance[i],
                ratingTrans[i].toFloat(),
                dateTrans[i],
                timeTrans[i],
                priceTrans,
                paymentMethod[i]
            )
            transactionList.add(transaction)
        }
    }

    private fun coverResource(doctor: String): Int {
        return when (doctor) {
            "Drh. Aji Kusuma" -> R.drawable.aji
            "Drh. Mutiara" -> R.drawable.mutiara
            "Drh. Chandra" -> R.drawable.chandra
            "Drh. Nadine" -> R.drawable.nadine
            "Drh. Caroline" -> R.drawable.caroline
            "Drh. Julia" -> R.drawable.julia
            "Drh. Aisha" -> R.drawable.aisha
            "Drh. Nalend" -> R.drawable.nalend
            "Drh. Isa" -> R.drawable.lisa
            "Drh. Annisa" -> R.drawable.annisa
            "Drh. Nabila" -> R.drawable.nabila
            "Drh. Dion" -> R.drawable.dion
            else -> R.drawable.aji
        }
    }

    private fun setupRecyclerView() {
        binding.rvHistory.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = TransactionListAdapter(transactionList, this@TransactionHistoryFragment)
        }
    }
}
