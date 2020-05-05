package com.github.lilzulf.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    companion object {
        val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        // get data from bundle intent
        ambilData()

        // intent to edit profile
        btnEditName.setOnClickListener {
            navigasiKeEditProfile()
        }

        // open dial
        btnCall.setOnClickListener {
            dialPhoneNumber(tvTelp.text.toString())
        }
    }

    private fun ambilData(){

        // get data bundle
        val bundle = intent.extras
        val nama = bundle!!.getString("nama")
        val gender = bundle!!.getString("gender")
        val email = bundle!!.getString("email")
        val telp = bundle!!.getString("telp")
        val alamat = bundle!!.getString("alamat")

        // set text from bundle
        tvName.text = nama
        tvGender.text = gender
        tvEmail.text = email
        tvTelp.text = telp
        tvAddress.text = alamat
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun navigasiKeEditProfile() {
        val intent = Intent(this, EditName::class.java)
        val namaUser = tvName.text.toString()
        intent.putExtra("nama", namaUser)
        startActivityForResult(intent, REQUEST_CODE)
    }
    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data:
    Intent?) {

        if (requestCode == REQUEST_CODE){
            // if result ok name edited
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("nama")
                tvName.text = result
            }else{
                Toast.makeText(this, "Edit failed",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}
