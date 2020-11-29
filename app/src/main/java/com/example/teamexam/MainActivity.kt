package com.example.teamexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton1.setOnClickListener {
            val intento1 = Intent(this, Dashboard::class.java)
            startActivity(intento1)

        }

        boton2.setOnClickListener {
            val intento1 = Intent(this, Registrarse::class.java)
            startActivity(intento1)

        }
    }
}