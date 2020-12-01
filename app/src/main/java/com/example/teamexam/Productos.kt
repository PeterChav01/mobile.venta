package com.example.teamexam

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_productos.*

class Productos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clientes)

        boton1.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this,"administracionn", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre", editText1.getText().toString())
            registro.put("descripcion", editText2.getText().toString())
            registro.put("cantidad", editText3.getText().toString().toFloat())
            registro.put("precio", editText4.getText().toString().toFloat())
            registro.put("url", editText5.getText().toString())
            registro.put("encargado", MainActivity.userName)

            bd.insert("productos", null, registro)
            bd.close()
            editText1.setText("")
            editText2.setText("")
            editText3.setText("")
            editText4.setText("")
            editText5.setText("")
            Toast.makeText(this, "Se cargaron los datos del Producto", Toast.LENGTH_SHORT).show()
        }

        boton2.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracionn", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select descripcion, cantidad, precio, url from productos where nombre='${editText1.text.toString()}'", null)
            if (fila.moveToFirst()) {
                editText2.setText(fila.getString(0))
                editText3.setText(fila.getString(1))
                editText4.setText(fila.getString(2))
                editText5.setText(fila.getString(3))
            } else
                Toast.makeText(this, "No existe un Producto con dicho nombre", Toast.LENGTH_SHORT).show()
            bd.close()
        }

        boton3.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracionn", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("descripcion", editText2.text.toString())
            registro.put("cantidad", editText3.text.toString().toFloat())
            registro.put("precio", editText4.text.toString().toFloat())
            registro.put("url", editText4.text.toString())
            val cant = bd.update("productos", registro, "nombre='${editText1.text.toString()}'", null)
            bd.close()
            if (cant == 1)
                Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un Producto con el nombre ingresado", Toast.LENGTH_SHORT).show()
        }

        boton4.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracionn", null, 1)
            val bd = admin.writableDatabase
            val cant = bd.delete("productos", "nombre='${editText1.text.toString()}'", null)
            bd.close()
            editText1.setText("")
            editText2.setText("")
            editText3.setText("")
            editText4.setText("")
            editText5.setText("")
            if (cant == 1)
                Toast.makeText(this, "Se borró el Producto con dicho nombre", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un Producto con dicho nombre", Toast.LENGTH_SHORT).show()
        }

    }
}