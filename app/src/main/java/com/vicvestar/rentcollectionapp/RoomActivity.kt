package com.vicvestar.rentcollectionapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.vicvestar.rentcollectionapp.databinding.ActivityRoomBinding

class RoomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoomBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveButton.setOnClickListener {
            val roomnumber = binding.roomnumberid.text.toString()
            val idnumber = binding.idNumber.text.toString()
            val floor = binding.floorid.text.toString()
            val fullnames = binding.fullnamesid.text.toString()

            database = FirebaseDatabase.getInstance().getReference("users")
            val user = user(roomnumber,idnumber,floor,fullnames)
            database.child(roomnumber).setValue(user).addOnSuccessListener {
              binding.roomnumberid.text.clear()
              binding.idNumber.text.clear()
              binding.floorid.text.clear()
              binding.fullnamesid.text.clear()

                Toast.makeText(this, "Successfully saved",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed",Toast.LENGTH_SHORT).show()
            }
        }
    }
}