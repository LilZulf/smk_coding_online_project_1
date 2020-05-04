package com.github.lilzulf.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_form_biodata.*

class FormBiodata : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_biodata)

        // Intent
        BtSave.setOnClickListener {
            startActivity(Intent(this@FormBiodata,ProfileActivity::class.java))
        }

    }
}
