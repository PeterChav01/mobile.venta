package com.example.teamexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.ContentValues
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registrarse.*

class Registrarse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)

        boton2.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this,"administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()

            registro.put("user", editText.getText().toString())
            registro.put("password", editText2.getText().toString())
            registro.put("email", editText3.getText().toString())
            registro.put("store", editText4.getText().toString())
            bd.insert("users", null, registro)
            bd.close()

            editText.setText("")
            editText2.setText("")
            editText3.setText("")
            editText4.setText("")

            Toast.makeText(this, "Se registro el usuario y la tienda", Toast.LENGTH_SHORT).show()
        }
    }
}