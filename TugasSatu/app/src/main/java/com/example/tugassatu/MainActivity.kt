package com.example.tugassatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var namaMahasiswa: TextView
    private lateinit var npmMahasiswa: TextView
    private lateinit var statusAkhir: TextView
    private lateinit var btKembali: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        namaMahasiswa = findViewById(R.id.tvNamaMhs)
        npmMahasiswa = findViewById(R.id.tvNpmMhs)
        statusAkhir = findViewById(R.id.tvStatusAkhir)
        btKembali = findViewById(R.id.btKembali)

        val nama = intent.getParcelableExtra<Student>("Student")?.name
        val npm = intent.getParcelableExtra<Student>("Student")?.npm
        val uts = intent.getParcelableExtra<Student>("Student")?.uts
        val uas = intent.getParcelableExtra<Student>("Student")?.uas

        namaMahasiswa.text = "Nama Mahasiswa\t: $nama"
        npmMahasiswa.text = "Nama Mahasiswa\t: $npm"

        if (uts != null && uas != null) {
            val hasilUjian = (uts + uas) / 2

            namaMahasiswa.text = "Nama\t: $nama"
            npmMahasiswa.text = "NPM\t\t: $npm"
            statusAkhir.text = if (hasilUjian > 76) "LULUS" else "TIDAK LULUS"

            if (hasilUjian > 76) {
                statusAkhir.setTextColor(android.graphics.Color.parseColor("#00FF00"))
                openFragment(ThumbsUpFragment())
            } else {
                statusAkhir.setTextColor(android.graphics.Color.parseColor("#FF0000"))
                openFragment(ThumbsDownFragment())
            }

        }

        val btKirim: Button = findViewById(R.id.btKembali)
        btKirim.setOnClickListener(this)

    }
    private fun openFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragmentStatusAkhir, fragment)
        fragmentTransaction.commit()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btKembali -> {
                val intent = Intent(this@MainActivity, InputFormActivity::class.java)
                startActivity(intent)
            }
        }
    }
}