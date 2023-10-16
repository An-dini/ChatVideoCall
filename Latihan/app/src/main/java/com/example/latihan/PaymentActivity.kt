package com.example.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val paymentMethodsRecyclerView: RecyclerView = findViewById(R.id.rvPaymentMethod)

        // Create the list of PaymentMethodModel items
        val paymentMethodsList = listOf(
            PaymentMethodModel(R.drawable.ic_dana_logo),
            PaymentMethodModel(R.drawable.ic_ovo_logo),
            PaymentMethodModel(R.drawable.ic_gopay_logo),
            PaymentMethodModel(R.drawable.ic_shopeepay_logo),
            PaymentMethodModel(R.drawable.ic_linkaja_logo),
            PaymentMethodModel(R.drawable.ic_mandiri_logo),
            PaymentMethodModel(R.drawable.ic_bca_logo),
            PaymentMethodModel(R.drawable.ic_bri_logo),
            PaymentMethodModel(R.drawable.ic_bni_logo)
        )

        // Create and set the adapter for the RecyclerView
        val paymentMethodsAdapter = PaymentMethodsAdapter(paymentMethodsList)
        paymentMethodsRecyclerView.adapter = paymentMethodsAdapter

        // Use a GridLayoutManager for a grid layout
        paymentMethodsRecyclerView.layoutManager = GridLayoutManager(this, 5)

        val viewMoreButton: Button = findViewById(R.id.viewMoreButton)
        viewMoreButton.setOnClickListener {
            // Ketika "lihat selengkapnya" diklik
            paymentMethodsAdapter.expandList()
            viewMoreButton.visibility = View.GONE // Sembunyikan tombol setelah diklik
        }

        val btpay: Button = findViewById(R.id.btPay)
        btpay.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}