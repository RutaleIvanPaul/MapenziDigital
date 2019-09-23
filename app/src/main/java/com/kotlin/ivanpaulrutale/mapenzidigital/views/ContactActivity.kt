package com.kotlin.ivanpaulrutale.mapenzidigital.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.kotlin.ivanpaulrutale.mapenzidigital.R

class ContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        populateSpinner(findViewById(R.id.spinner),this)
    }

    override fun onBackPressed() {
        startActivity(Intent(this,MainActivity::class.java))
    }


}
