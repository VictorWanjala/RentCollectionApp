package com.vicvestar.rentcollectionapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        PayRent.setOnClickListener {
            val intent = Intent(this, PayActivity::class.java)
            startActivity(intent)
        }
    }
}