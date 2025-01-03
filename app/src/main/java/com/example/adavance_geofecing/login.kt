package com.example.adavance_geofecing

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    lateinit var auth : FirebaseAuth

    val dropDownList = arrayOf("Select User","User","Admin")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edemail = findViewById<EditText>(R.id.edemail)
        val edpassword = findViewById<EditText>(R.id.edpassword)
        val btnlogin = findViewById<Button>(R.id.btnlogin)
        val txtforgotuser = findViewById<TextView>(R.id.txtforgotuser)
        val txtreguser = findViewById<TextView>(R.id.txtreguser)


        val statusFillter = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dropDownList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        statusFillter.adapter = adapter
        statusFillter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                if (statusFillter.selectedItemPosition == 1) {
                    Toast.makeText(
                        applicationContext,
                        statusFillter.selectedItem.toString(),
                        Toast.LENGTH_LONG
                    ).show()

                } else if (statusFillter.selectedItemPosition == 2) {
                    Toast.makeText(
                        applicationContext,
                        statusFillter.selectedItem.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                    val intent = Intent(applicationContext,Adminlogin::class.java)
                    startActivity(intent)
                }
            }


            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        //got to register activity

        txtreguser.setOnClickListener {
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)

        }

        auth = FirebaseAuth.getInstance()

        //login
        btnlogin.setOnClickListener {

            if(edemail.text.isEmpty() ) {
                edemail.setError("Enter Email Id")
                return@setOnClickListener
            }
            else if (edpassword.text.isEmpty()){
                edpassword.setError("Enter Password")
                return@setOnClickListener
            }



            auth.signInWithEmailAndPassword(edemail.text.toString(),edpassword.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful)
                    {
                        Toast.makeText(applicationContext,"successfully Login", Toast.LENGTH_LONG).show()
                        val intent = Intent(applicationContext, home::class.java)
                        startActivity(intent)
                    }
                    else
                    {
                        Toast.makeText(applicationContext,"Failed to login", Toast.LENGTH_LONG).show()
                    }
                }
        }

        //forgot password
        txtforgotuser.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Forgot Password")
            val view = layoutInflater.inflate(R.layout.dailog_forgot,null)
            val username = view.findViewById<EditText>(R.id.ed_forgot)
            builder.setView(view)
            builder.setPositiveButton("Reset", DialogInterface.OnClickListener { _, _ ->
                forgotpassword(username)
            })
            builder.setNegativeButton("Close", DialogInterface.OnClickListener { _, _ ->  })
            builder.show()

        }
    }

    private fun forgotpassword(username: EditText?) {

        auth.sendPasswordResetEmail(username!!.text.toString())
            .addOnCompleteListener {
                if(it.isSuccessful)
                {
                    Toast.makeText(applicationContext,"Email Sent", Toast.LENGTH_LONG).show()
                }
            }


    }
}