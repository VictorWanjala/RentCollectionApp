package com.vicvestar.rentcollectionapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.vicvestar.rentcollectionapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener {

            val email = binding.email.text.toString()
            val pass = binding.password.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()){

                    firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener{
                        if (it.isSuccessful) {
                            val intent = Intent(this, DashboardActivity::class.java)
                            startActivity(intent)

                            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

            }else{
                Toast.makeText(this, "Empty fields are not allowed!!", Toast.LENGTH_SHORT).show()
            }

        }

    }


}