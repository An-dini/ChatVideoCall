package com.example.tugassatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class InputFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var namaMahasiswa: EditText
    private lateinit var npmMahasiswa: EditText
    private lateinit var nilaiUts: EditText
    private lateinit var nilaiUas: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_form)

        namaMahasiswa = findViewById(R.id.namaMhs)
        npmMahasiswa = findViewById(R.id.npmMhs)
        nilaiUts = findViewById(R.id.nilaiUts)
        nilaiUas = findViewById(R.id.nilaiUas)

        val btKirim: Button = findViewById(R.id.btKirim)
        btKirim.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btKirim -> {
                val intent = Intent(this@InputFormActivity, MainActivity::class.java)
                intent.putExtra("Student", Student(namaMahasiswa.text.toString(), npmMahasiswa.text.toString(), nilaiUts.text.toString().toDouble(), nilaiUas.text.toString().toDouble()))
                startActivity(intent)
            }
        }
    }

}