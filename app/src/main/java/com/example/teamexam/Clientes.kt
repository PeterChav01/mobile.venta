package com.example.teamexam

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_clientes.*
import com.example.teamexam.MainActivity.Companion.userName

class Clientes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clientes)

        boton1.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this,"administracionn", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre", editText1.getText().toString())
            registro.put("direccion", editText2.getText().toString())
            registro.put("telefono", editText3.getText().toString())
            registro.put("email", editText4.getText().toString())
            registro.put("encargado", userName)

            bd.insert("cliente", null, registro)
            bd.close()
            editText1.setText("")
            editText2.setText("")
            editText3.setText("")
            editText4.setText("")
            Toast.makeText(this, "Se cargaron los datos del Cliente", Toast.LENGTH_SHORT).show()
        }

        boton2.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracionn", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select direccion, telefono, email from cliente where nombre='${editText1.text.toString()}'", null)
            if (fila.moveToFirst()) {
                editText2.setText(fila.getString(0))
                editText3.setText(fila.getString(1))
                editText4.setText(fila.getString(2))
            } else
                Toast.makeText(this, "No existe un Cliente con dicho nombre", Toast.LENGTH_SHORT).show()
            bd.close()
        }
/*
        boton3.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("update cliente set direccion = '${editText2.text.toString()}', telefono = '${editText3.text.toString()}', email = '${editText4.text.toString()}' where nombre='${editText1.text.toString()}'", null)
            if (fila == null) {

            } else
                Toast.makeText(this, "No existe un Cliente con dicho nombre", Toast.LENGTH_SHORT).show()
            bd.close()
        }

        boton4.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("delete * from cliente where nombre='${editText1.text.toString()}'", null)
            if (fila == null) {

            } else
                Toast.makeText(this, "No existe un Cliente con dicho nombre", Toast.LENGTH_SHORT).show()
            bd.close()
        }
*/
        boton3.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracionn", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("direccion", editText2.text.toString())
            registro.put("telefono", editText3.text.toString())
            registro.put("email", editText4.text.toString())
            val cant = bd.update("cliente", registro, "nombre='${editText1.text.toString()}'", null)
            bd.close()
            if (cant == 1)
                Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un Cliente con el nombre ingresado", Toast.LENGTH_SHORT).show()
        }

        boton4.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracionn", null, 1)
            val bd = admin.writableDatabase
            val cant = bd.delete("cliente", "nombre='${editText1.text.toString()}'", null)
            bd.close()
            editText1.setText("")
            editText2.setText("")
            editText3.setText("")
            editText4.setText("")
            if (cant == 1)
                Toast.makeText(this, "Se borró el Cliente con dicho nombre", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un Clienteo con dicho nombre", Toast.LENGTH_SHORT).show()
        }

    }
}