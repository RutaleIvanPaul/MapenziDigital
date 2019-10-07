package com.kotlin.ivanpaulrutale.mapenzidigital.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.kotlin.ivanpaulrutale.mapenzidigital.R
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.android.synthetic.main.activity_payment_details.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import ug.co.yo.yopay.yopaymentslibrary.YoPay
import ug.co.yo.yopay.yopaymentslibrary.YoPaymentsResponse
import java.lang.IllegalArgumentException
//import android.R
import java.util.concurrent.ExecutionException


class PaymentActivity : AppCompatActivity() {

    var waitTimeCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val shoppingCart = intent.getIntegerArrayListExtra("shoppingCart")
        var shoppingCartTextArea:TextView = findViewById(R.id.descriptionTextView)
        val confirmOrderButton:Button = findViewById(R.id.confirm_order)
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
            confirmOrderButton.isEnabled = false
            confirmOrderButton.text = "Waiting ..."
            progressBar.visibility = View.VISIBLE
            startPayment(totalCharge)
        }

    }

    private fun startPayment(total:Double) {
        try {
            if (phonenumber.text.isEmpty() || phonenumber.text.length < 10 ){
                throw IllegalArgumentException("Please Input a correct number!")
            }
            val trimmedNumber = "256"+phonenumber.text.substring(1,10)

            CoroutineScope(IO).launch {
                val transactionReference = makePayment(trimmedNumber,total)
                checkTransaction(transactionReference,trimmedNumber,total)

            }


        } catch (e: InterruptedException) {
            progressBar.visibility = View.INVISIBLE
            e.printStackTrace()
            Toast.makeText(this,"Something went wrong! Please retry",Toast.LENGTH_LONG).show()
            startActivity(Intent(this,OrderActivity::class.java))
        } catch (e: ExecutionException) {
            progressBar.visibility = View.INVISIBLE
            e.printStackTrace()
        } catch (e: IllegalArgumentException){
            e.printStackTrace()
            progressBar.visibility = View.INVISIBLE
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
        }
    }

    private suspend fun makePayment(phoneNumber:String,amount:Double):String{
        yoAPI.nonBlocking = true
        val response =  yoAPI.ac_deposit_funds(phoneNumber,amount,"Mapenzi Digital Services")
        delay(3000)
        Log.i("YO PAY RESPONSE",response.toString())

        if (response.transactionReference == null){
            withContext(Main){
                throw InterruptedException("Something went wrong! Please retry")
            }
        }

        return response.transactionReference

    }

    private suspend fun checkTransaction(transactionReference: String?,phoneNumber: String,total: Double) {
        yoAPI.nonBlocking = true
        val transactionStatus = yoAPI.ac_check_transaction_status(transactionReference)
        val confirmOrderButton:Button = findViewById(R.id.confirm_order)
        val dialogBuilder = AlertDialog.Builder(this)
        if (transactionStatus == null){
            delay(5000)
        }
        if (transactionStatus.transactionStatus.equals("success",ignoreCase = true)){
            withContext(Main){
                titleTextView3.visibility = View.VISIBLE
                clientLabel.visibility = View.VISIBLE
                clientID.visibility = View.VISIBLE
                amountLabel.visibility = View.VISIBLE
                amount.visibility = View.VISIBLE
                messageLabel.visibility = View.VISIBLE
                message.visibility = View.VISIBLE


                clientID.text = phoneNumber
                amount.text = total.toString()
                message.text = "SUCCESSFULLY PAID"
                confirmOrderButton.text = "DONE"
                progressBar.visibility = View.INVISIBLE

                dialogBuilder.setTitle("Success")
                dialogBuilder.setMessage("You have successfully paid.")
                dialogBuilder.setPositiveButton("OK"){dialog,which ->
                    startActivity(Intent(applicationContext,OrderActivity::class.java))
                }
            }

        }
        else if (transactionStatus.transactionStatus.equals("pending",ignoreCase = true) && waitTimeCounter < 36){
            Log.i("CHECKINGPENDINGTRNSCN",waitTimeCounter.toString())
            waitTimeCounter++
            checkTransaction(transactionReference,phoneNumber,total)
        }
        else{
            withContext(Main){
                titleTextView3.visibility = View.VISIBLE
                clientLabel.visibility = View.VISIBLE
                clientID.visibility = View.VISIBLE
                amountLabel.visibility = View.VISIBLE
                amount.visibility = View.VISIBLE
                messageLabel.visibility = View.VISIBLE
                message.visibility = View.VISIBLE

                clientID.text = phoneNumber
                amount.text = total.toString()
                message.text = "FAILED TRANSACTION"
                confirmOrderButton.isEnabled = true
                confirmOrderButton.text = "Submit"
                progressBar.visibility = View.INVISIBLE

                dialogBuilder.setTitle("Failed")
                dialogBuilder.setMessage("Transaction Failed. Are you sure the phone number is correct?")
                dialogBuilder.setPositiveButton("OK"){ _, which ->
                    startActivity(Intent(applicationContext,OrderActivity::class.java))
                }
            }
        }
    }



}
