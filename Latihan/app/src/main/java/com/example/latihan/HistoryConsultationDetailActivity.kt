package com.example.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import com.example.latihan.databinding.HistoryConsultationDetailBinding

class HistoryConsultationDetailActivity : AppCompatActivity() {
    private lateinit var binding: HistoryConsultationDetailBinding
    private lateinit var btNewSchedule: Button
    private lateinit var btConsultationHistory: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HistoryConsultationDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btNewSchedule = findViewById(R.id.bt_newSchedule)
        btConsultationHistory = findViewById(R.id.bt_consultationHistory)

        val transactionID = intent.getIntExtra("transactionId", -1)
        val transaction = transactionFromID(transactionID)
        Log.d("HistoryConsultationDetailActivity", "Transaction ID: $transactionID")

        if (transaction != null) {
            binding.cover.setImageResource(transaction.cover)
            binding.name.text = transaction.doctor
            binding.instance.text = transaction.instance
            binding.date.text = transaction.date
            binding.time.text = transaction.time
            binding.price.text = transaction.price
            binding.ratingBar.rating = transaction.rating
        }

        btNewSchedule.setOnClickListener {
            val intent = Intent(this, ScheduleConsultationActivity::class.java)
            startActivity(intent)
        }

        btConsultationHistory.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }

        val backButton = findViewById(R.id.btPrev) as ImageView

        backButton.setOnClickListener {
            onBackPressed()
        }

    }

    private fun transactionFromID(transactionID: Int): Transaction?
    {
        for(transaction in transactionList)
        {
            if(transaction.id == transactionID)
                return transaction
        }
        return null
    }

}