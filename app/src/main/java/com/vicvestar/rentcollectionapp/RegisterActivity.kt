package com.vicvestar.rentcollectionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.vicvestar.rentcollectionapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var database: DatabaseReference
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()


        binding.btnRegister.setOnClickListener {

            val email = binding.email.text.toString()
            val pass = binding.password.text.toString()
            val confirmpass = binding.cpassword.text.toString()


            if (email.isNotEmpty() && pass.isNotEmpty() && confirmpass.isNotEmpty()){
                if (pass == confirmpass){
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener{
                       if (it.isSuccessful) {
                           val intent = Intent(this, LoginActivity::class.java)
                           startActivity(intent)

                           Toast.makeText(this, "Registration Successful, please proceed to login", Toast.LENGTH_SHORT).show()

                       }else{
                           Toast.makeText(this, it.exception.toString(),Toast.LENGTH_SHORT).show()
                       }
                    }

                }else{
                    Toast.makeText(this, "Password does not match",Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(this, "Empty fields are not allowed!!",Toast.LENGTH_SHORT).show()
            }

        }


    }
}

