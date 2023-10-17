package com.example.latihan


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity()
{
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationBar)


        if (intent.getBooleanExtra("transaction_data", false)) {
            replaceFragment(TransactionHistoryFragment())
            bottomNavigationView.selectedItemId = R.id.riwayat
        }
        if (intent.getBooleanExtra("newSchedule", false)) {
            replaceFragment(DoctorFragment())
            bottomNavigationView.selectedItemId = R.id.dokter
        } else {
            replaceFragment(BerandaFragment())
            bottomNavigationView.selectedItemId = R.id.beranda
        }

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.beranda -> {
                    replaceFragment(BerandaFragment())
                    true
                }

                R.id.dokter -> {
                    replaceFragment(DoctorFragment())
                    true
                }

                R.id.diskusi -> {
                    replaceFragment(DiskusiFragment())
                    true
                }

                R.id.riwayat -> {
                    replaceFragment(TransactionHistoryFragment())
                    true
                }

                R.id.info -> {
                    replaceFragment(InfoFragment())
                    true
                }

                else -> false
            }
        }
//        replaceFragment(BerandaFragment())
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.commit()
        Log.d("MyApp", "Replacing fragment with ${fragment.javaClass.simpleName}")
    }

}






