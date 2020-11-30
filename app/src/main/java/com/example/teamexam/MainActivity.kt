package com.example.teamexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton1.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val intento1 = Intent(this, Dashboard::class.java)

            val fila = bd.rawQuery("select id from users where user='${editText.text.toString()}' and password='${editText2.text.toString()}'", null)
            if (fila.moveToFirst()) {
                startActivity(intento1)
            } else
                Toast.makeText(this, "El usuario no existe",  Toast.LENGTH_SHORT).show()
            bd.close()
        }

        boton2.setOnClickListener {
            val intento1 = Intent(this, Registrarse::class.java)
            startActivity(intento1)
        }


    }
}