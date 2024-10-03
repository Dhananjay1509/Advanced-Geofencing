package com.example.adavance_geofecing

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide

class prodetails : AppCompatActivity() {

    var name:String?=null
    var address:String?=null
    var mobileno:String?=null
    var item1:String?=null
    var price1:String?=null
    var item2:String?=null
    var price2:String?=null
    var item3:String?=null
    var price3:String?=null
    var url:String?=null
    var lati:String?=null
    var longi:String?=null



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prodetails)

        val txtname = findViewById<TextView>(R.id.txtname)
        val txtaddress = findViewById<TextView>(R.id.txtaddress)
        val txtmobile = findViewById<TextView>(R.id.txtmobile)
        val txtitem1 = findViewById<TextView>(R.id.txtitem1)
        val txtprice1 = findViewById<TextView>(R.id.txtprice1)
        val txtitem2 = findViewById<TextView>(R.id.txtitem2)
        val txtitem3 = findViewById<TextView>(R.id.txtitem3)
        val btn = findViewById<Button>(R.id.btnsend)

        val rBar = findViewById<RatingBar>(R.id.rBar)



        rBar.rating = 3.5f
        rBar.stepSize = .5f







        val image = findViewById<ImageView>(R.id.image1)
        val bundle = intent.extras



        name = bundle!!.getString("sname")
        address = bundle.getString("address")
        mobileno = bundle.getString("number")
        item1=bundle.getString("product1")
        price1 = bundle.getString("offer1")
        item2=bundle.getString("product2")
        item3=bundle.getString("offer2")
        lati = bundle.getString("lati")
        longi = bundle.getString("longi")


        url = bundle.getString("url")

        Glide.with(applicationContext).load(url).into(image)

        txtname.text = "Shop name: "+name
        txtaddress.text = "Address: " +address
        txtmobile.text = "Mobile No: "+mobileno
        txtitem1.text = "Product : " + item1
        txtprice1.text = "Offer: "+price1
        txtitem2.text = "product :  "+item2
        txtitem3.text = "Offer : "+ item3



        val btnsms = findViewById<Button>(R.id.btnsms)

        btnsms.setOnClickListener {
            val smsManager = SmsManager.getDefault() as SmsManager
            smsManager.sendTextMessage("+91$mobileno",null,"I am Interested",null,null)

        }
        btn.setOnClickListener {
            try {
                val uri = Uri.parse("https://www.google.co.in/maps/dir/"+"/"+ address)

                val intent = Intent(Intent.ACTION_VIEW,uri)
                intent.setPackage("com.google.android.apps.maps")
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

            }catch (e: ActivityNotFoundException)
            {
                val uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps")
                val intent = Intent(Intent.ACTION_VIEW,uri)
                intent.setPackage("com.google.android.apps.maps")
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }

        }

    }
}