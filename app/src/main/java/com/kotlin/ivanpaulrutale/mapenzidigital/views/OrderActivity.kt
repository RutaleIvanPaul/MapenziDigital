package com.kotlin.ivanpaulrutale.mapenzidigital.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import com.kotlin.ivanpaulrutale.mapenzidigital.R

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        populateSpinner(findViewById(R.id.spinner),this)
    }

    override fun onBackPressed() {
        startActivity(Intent(this,MainActivity::class.java))
    }
}
