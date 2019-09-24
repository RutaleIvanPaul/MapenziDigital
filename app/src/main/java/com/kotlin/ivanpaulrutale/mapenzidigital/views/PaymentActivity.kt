package com.kotlin.ivanpaulrutale.mapenzidigital.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.kotlin.ivanpaulrutale.mapenzidigital.R

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val shoppingCart = intent.getIntegerArrayListExtra("shoppingCart")
        var shoppingCartTextArea:TextView = findViewById(R.id.descriptionTextView)
        var shoppingCartString = ""
        var totalCharge =0
        if (shoppingCart.contains(1)){
            shoppingCartString+="\nService 1: 100"
            totalCharge+=100
        }
        if (shoppingCart.contains(2)){
            shoppingCartString+="\nService 2: 200"
            totalCharge+=200
        }
        if (shoppingCart.contains(3)){
            shoppingCartString+="\nService 3: 300"
            totalCharge+=300
        }
        shoppingCartString+="\nTotal:"+totalCharge
        shoppingCartTextArea.text = shoppingCartString

    }

}
