package com.github.lilzulf.myapplication

import android.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_about.*


class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.github.lilzulf.myapplication.R.layout.activity_about)
        setTitle("About Page")
        Toast.makeText(this, "Coba beberapa item bisa diclick lohh", Toast.LENGTH_LONG).show()
        tvMl.setOnClickListener {
            Toast.makeText(this, "Akun ml saya : WAGELASEH ", Toast.LENGTH_LONG).show()
        }
        LlAddress.setOnClickListener {
           openMaps()
        }
        LlPhone.setOnClickListener {
            dialPhoneNumber(TvPhone.text.toString())
        }
    }
    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    private fun openMaps(){
        val gmmIntentUri: Uri = Uri.parse("geo:-8.078232,112.640683?q=Jalan Diponegoro I, Bululawang, Malang, Jawa Timur")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }else{
            Toast.makeText(this, "Anda belum memasang google maps ", Toast.LENGTH_SHORT).show()
        }
    }

}
