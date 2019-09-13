package com.kotlin.ivanpaulrutale.mapenzidigital.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.ivanpaulrutale.mapenzidigital.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.app_bar_main.*

class ItemDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val image = intent.getStringExtra("image")



        findViewById<TextView>(R.id.titleTextView).text = title
        findViewById<TextView>(R.id.descriptionTextView).text = description
    }
}
