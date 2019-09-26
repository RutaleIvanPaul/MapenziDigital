package com.kotlin.ivanpaulrutale.mapenzidigital.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.kotlin.ivanpaulrutale.mapenzidigital.R
import kotlinx.android.synthetic.main.activity_payment.*
import ug.co.yo.yopay.yopaymentslibrary.YoPay
import ug.co.yo.yopay.yopaymentslibrary.YoPaymentsResponse
import java.lang.IllegalArgumentException
//import android.R
import java.util.concurrent.ExecutionException


class PaymentActivity : AppCompatActivity() {

    val yoAPI: YoPay = YoPay("100118955773","z1gw-ybMI-ptek-jM0O-amJh-VkOJ-TeSt-2NSq")
    var waitTimeCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val confirmOrderButton:Button = findViewById(R.id.confirm_order)
        val shoppingCart = intent.getIntegerArrayListExtra("shoppingCart")
        var shoppingCartTextArea:TextView = findViewById(R.id.descriptionTextView)
        var shoppingCartString = ""
        var totalCharge:Double = 0.0
        if (shoppingCart.contains(1)){
            shoppingCartString+="\nQR code access control: 2,000,000"
            totalCharge+=2000000
        }
        if (shoppingCart.contains(2)){
            shoppingCartString+="\nE-ticketing and e-cards: 1,500,000"
            totalCharge+=1500000
        }
        if (shoppingCart.contains(3)){
            shoppingCartString+="\nSocial media management: 3,000,000"
            totalCharge+=3000000
        }
        if (shoppingCart.contains(4)){
            shoppingCartString+="\nWebsite analytics: 3,000,000"
            totalCharge+=3000000
        }
        if (shoppingCart.contains(5)){
            shoppingCartString+="\nAudio Visual : 1,500,000"
            totalCharge+=1500000
        }
        if (shoppingCart.contains(6)){
            shoppingCartString+="\nVideo shoot: 1,500,000"
            totalCharge+=1500000
        }
        if (shoppingCart.contains(7)){
            shoppingCartString+="\nBusiness cards, posters: 1,000,000"
            totalCharge+=1000000
        }
        if (shoppingCart.contains(8)){
            shoppingCartString+="\nAnimations:￼2,000,000"
            totalCharge+=2000000
        }
        if (shoppingCart.contains(9)){
            shoppingCartString+="\nPublic Relations: 1,500,000"
            totalCharge+=15000000
        }
        if (shoppingCart.contains(10)){
            shoppingCartString+="\nYouTube channels: 1,000,000"
            totalCharge+=1000000
        }
        if (shoppingCart.contains(11)){
            shoppingCartString+="\nSearch Engine Management: 2,000,000"
            totalCharge+=2000000
        }
        if (shoppingCart.contains(12)){
            shoppingCartString+="\nE-mail  management: 1,000,000"
            totalCharge+=1000000
        }
        if (shoppingCart.contains(13)){
            shoppingCartString+="\nPay-Per-Click: 1,500,000"
            totalCharge+=1500000
        }
        if (shoppingCart.contains(14)){
            shoppingCartString+="\nReputation Management: 1,500,000"
            totalCharge+=1500000
        }
        if (shoppingCart.contains(15)){
            shoppingCartString+="\nPhotography: 1,000,000"
            totalCharge+=1000000
        }
        if (shoppingCart.contains(16)){
            shoppingCartString+="\nVideography: 1,200,000"
            totalCharge+=1200000
        }
        if (shoppingCart.contains(17)){
            shoppingCartString+="\nContent Management: 800,000"
            totalCharge+=800000
        }
        if (shoppingCart.contains(18)){
            shoppingCartString+="\nMobile Marketing : 1,000,000"
            totalCharge+=1000000
        }
        if (shoppingCart.contains(19)){
            shoppingCartString+="\nQR coded cards: 1,200,000"
            totalCharge+=1200000
        }
        if (shoppingCart.contains(20)){
            shoppingCartString+="\nConversion Management: 1,000,000"
            totalCharge+=1000000
        }
        if (shoppingCart.contains(21)){
            shoppingCartString+="\nHour photo shoot: 1,000,000"
            totalCharge+=1000000
        }
        if (shoppingCart.contains(22)){
            shoppingCartString+="\nPrinted tags and cards: 800,000"
            totalCharge+=800000
        }
        if (shoppingCart.contains(23)){
            shoppingCartString+="\nFootage Sales: 700,000"
            totalCharge+=700000
        }
        if (shoppingCart.contains(24)){
            shoppingCartString+="\nArchitectural deign: 1,300,000"
            totalCharge+=1300000
        }
        if (shoppingCart.contains(25)){
            shoppingCartString+="\nUI and UX design: 1,500,000"
            totalCharge+=1500000
        }
        if (shoppingCart.contains(26)){
            shoppingCartString+="\nDocumentary Production: 1,500,000"
            totalCharge+=1500000
        }
        if (shoppingCart.contains(27)){
            shoppingCartString+="\nCustomizing websites: 1,500,000"
            totalCharge+=1500000
        }
        shoppingCartString+="\n\nTOTAL: UGX"+totalCharge
        shoppingCartTextArea.text = shoppingCartString


        confirmOrderButton.setOnClickListener{
            makePayment(totalCharge)
        }

    }

    private fun makePayment(total:Double) {
        progressBar.visibility = View.VISIBLE
        try {
            if (phonenumber.text.isEmpty() || phonenumber.text.length < 10 ){
                throw IllegalArgumentException("Please Input a correct number!")
            }
            val trimmedNumber = "256"+phonenumber.text.substring(1,10)

            yoAPI.nonBlocking = true
           val response =  yoAPI.ac_deposit_funds(trimmedNumber,1000.0,"Mapenzi Digital Services")
            Thread.sleep(5000)
            val transactionReference = response.transactionReference

            checkTransaction(transactionReference)

            Log.i("YO PAY RESPONSE",response.toString())
        } catch (e: InterruptedException) {
//            progressBar.visibility = View.INVISIBLE
            e.printStackTrace()
        } catch (e: ExecutionException) {
//            progressBar.visibility = View.INVISIBLE
            e.printStackTrace()
        } catch (e: IllegalArgumentException){
            e.printStackTrace()
            progressBar.visibility = View.INVISIBLE
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
        }
    }

    private fun checkTransaction(transactionReference: String?) {
        yoAPI.nonBlocking = true
        val transactionStatus = yoAPI.ac_check_transaction_status(transactionReference)
        Thread.sleep(5000)
        if (transactionStatus == null){
            Thread.sleep(10000)
        }
        if (transactionStatus.transactionStatus.equals("success",ignoreCase = true)){
//            progressBar.visibility = View.INVISIBLE
            Toast.makeText(this,"Successfully Paid",Toast.LENGTH_LONG).show()
            startActivity(Intent(this,MainActivity::class.java))
        }
        else if (transactionStatus.transactionStatus.equals("pending",ignoreCase = true) && waitTimeCounter < 60){
            progressBar.visibility = View.VISIBLE
            Toast.makeText(this,"Transaction Pending, Please Wait!",Toast.LENGTH_LONG).show()
            Log.i("CHECKINGPENDINGTRNSCN",waitTimeCounter.toString())
            waitTimeCounter++
            checkTransaction(transactionReference)
        }
        else{
            progressBar.visibility = View.INVISIBLE
            Log.i("FAILED TRANSACTION",transactionStatus.errorMessage)
            Toast.makeText(this,transactionStatus.errorMessage,Toast.LENGTH_LONG).show()
            startActivity(Intent(this,OrderActivity::class.java))
        }
    }

}
