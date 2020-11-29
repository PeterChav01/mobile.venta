package com.example.teamexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        imgbtn3.setOnClickListener {
            val intento1 = Intent(this, Ventas::class.java)
            startActivity(intento1)
        }

        imgbtn4.setOnClickListener {
            val intento1 = Intent(this, Reportes::class.java)
            startActivity(intento1)
        }


    }
}