package com.github.lilzulf.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form_biodata.*

class FormBiodata : AppCompatActivity() {

    private var name : String = ""
    private var email : String = ""
    private var phone : String = ""
    private var address : String = ""
    private var gender : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_biodata)

        // set data for spinner
        setDataSpinnerGender()

        // click to input validation
        BtSave.setOnClickListener {
           inputValidation()
        }

    }

    private fun inputValidation(){
         name = EtName.text.toString().trim()
         email = EtEmail.text.toString().trim()
         phone = EtPhone.text.toString().trim()
         address = EtAddress.text.toString().trim()
         gender = spinnerGender.selectedItem.toString().trim()

        // validation
        when{
            name.isEmpty() -> EtName.error = "Nama tidak boleh kosong"
            email.isEmpty() -> EtEmail.error = "Email tidak boleh kosong"

            // email patterns validation
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> EtEmail.error = "Email tidak valid"

            phone.isEmpty() -> EtPhone.error = "Nomer telpon tidak boleh kosong"
            address.isEmpty() -> EtAddress.error = "Alamat tidak boleh kosong"
            gender.equals("Pilih Jenis Kelamin", ignoreCase = true) ->
                tampilToast("Jenis Kelamin harus dipilih")
            else -> {
                tampilToast("Pindah ke halaman profile")
                goToProfileActivity()
            }
        }

    }
    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun goToProfileActivity() {
        // intent to Profile activity
        val intent = Intent(this, ProfileActivity::class.java)

        // data bundle
        val bundle = Bundle()
        bundle.putString("nama", name)
        bundle.putString("gender", gender)
        bundle.putString("email", email)
        bundle.putString("telp", phone)
        bundle.putString("alamat", address)
        intent.putExtras(bundle)

        startActivity(intent)
    }

    private fun setDataSpinnerGender(){
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.jenis_kelamin, android.R.layout.simple_spinner_item)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerGender.adapter = adapter
    }
}
