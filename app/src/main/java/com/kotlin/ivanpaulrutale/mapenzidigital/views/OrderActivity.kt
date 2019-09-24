package com.kotlin.ivanpaulrutale.mapenzidigital.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import com.kotlin.ivanpaulrutale.mapenzidigital.R

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val submit_order:Button = findViewById(R.id.submit_order)
        val checkBox1:CheckBox= findViewById(R.id.checkBox1)
        val checkBox2:CheckBox= findViewById(R.id.checkBox2)
        val checkBox3:CheckBox= findViewById(R.id.checkBox3)
        submit_order.setOnClickListener{
            val shoppingCart = ArrayList<Int>()
            val intent= Intent(this,PaymentActivity::class.java)
            if (checkBox1.isChecked){
                shoppingCart.add(1)
            }
            if (checkBox2.isChecked){
                shoppingCart.add(2)
            }
            if (checkBox3.isChecked){
                shoppingCart.add(3)
            }
            intent.putIntegerArrayListExtra("shoppingCart",shoppingCart)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        startActivity(Intent(this,MainActivity::class.java))
    }
}
