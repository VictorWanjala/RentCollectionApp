package com.vicvestar.rentcollectionapp

import android.content.Intent
import android.os.Bundle
import android.net.Uri
import androidx.cardview.widget.CardView
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
        Call.setOnClickListener {
            val intent =  Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:0700794573"));
            startActivity(intent);
        }
    }
}