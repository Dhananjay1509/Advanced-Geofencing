package com.example.adavance_geofecing

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Adminregister : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adminregister)

        val name = findViewById<EditText>(R.id.edusername)

        val number = findViewById<EditText>(R.id.ednumber)
        val email = findViewById<EditText>(R.id.edemail)
        val password = findViewById<EditText>(R.id.edpassword)
        val btn = findViewById<Button>(R.id.btnregister)

         val txtlogin = findViewById<TextView>(R.id.txtlogin)

        txtlogin.setOnClickListener(){
            val intent = Intent(applicationContext,Adminlogin::class.java)
            startActivity(intent)
        }

        auth = FirebaseAuth.getInstance()

        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("Admin")

        btn.setOnClickListener {
            if(name.text.isEmpty())
            {
                name.setError("Enter name")
                return@setOnClickListener
            }else if(password.text.isEmpty())
            {
                password.setError("Enter Password ")
                return@setOnClickListener
            }else if(number.text.isEmpty())
            {
                number.setError("Enter Contact Number")
                return@setOnClickListener
            }else if(email.text.isEmpty())
            {
                email.setError("Enter Email id")
                return@setOnClickListener
            }


            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful)
                    {
                        val currentuser = auth.currentUser
                        val currentUserdb = databaseReference?.child((currentuser?.uid!!))
                        currentUserdb?.child("name")?.setValue(name.text.toString())


                        currentUserdb?.child("number")?.setValue(number.text.toString())

                        Toast.makeText(applicationContext,"success", Toast.LENGTH_LONG).show()
//                        Toast.makeText(applicationContext,adhar.text.toString(), Toast.LENGTH_LONG).show()


                    }
                    else
                    {
                        Toast.makeText(applicationContext,"failed", Toast.LENGTH_LONG).show()
                    }
                }
        }

    }
}