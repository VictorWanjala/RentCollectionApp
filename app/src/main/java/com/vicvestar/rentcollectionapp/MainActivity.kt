package com.vicvestar.rentcollectionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            btnRegister.setOnClickListener {
                //code that will be executed on click on the Login button
                Toast.makeText(this,  "Already have an account?!, Click on Login button to Access", Toast.LENGTH_SHORT).show()


                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)

                btnLogin.setOnClickListener {
                    //code that will be executed on click on the Login button
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)


            }



        }

    }
}