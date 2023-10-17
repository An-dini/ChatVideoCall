package com.example.latihan

var transactionList = mutableListOf<Transaction>()

val TRANSACTION_ID_EXTRA = "transactionExtra"
data class Transaction(
    val cover: Int,
    val doctor: String,
    val instance: String,
    val rating: Float,
    val date: String,
    val time: String,
    val price: Int,
    val paymentMethod: String,
    val id: Int? = transactionList.size
)
