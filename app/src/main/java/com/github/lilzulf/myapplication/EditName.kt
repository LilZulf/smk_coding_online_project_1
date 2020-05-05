package com.github.lilzulf.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_name.*

class EditName : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_name)

        val intentData = intent.extras
        val namaUser = intentData!!.getString("nama")
        etEditName.setText(namaUser)

        btEditSave.setOnClickListener {
            saveData()
        }
    }
    private fun saveData(){
        val name = etEditName.text.toString().trim()

        // if emtpty canceled
        if(name.isEmpty()){
            setResult(Activity.RESULT_CANCELED)
        }else{

            // set result
            val result = Intent()
            result.putExtra("nama", name)
            setResult(Activity.RESULT_OK, result)
        }
        finish()
    }
}
