package com.example.teamexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_clientes.*
import kotlinx.android.synthetic.main.activity_ventas.*;


class Ventas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventas)

        var listaClientes = ArrayList<String>();
        var listaProductos = ArrayList<String>();
        var n = 0;
        val admin = AdminSQLiteOpenHelper(this, "administracionn", null, 1)
        val bd = admin.writableDatabase
        val fila = bd.rawQuery("select nombre from cliente", null)
        val filaproductos = bd.rawQuery("select nombre from productos", null)

        if (fila.moveToFirst()) {
            while (n < fila.count) {
                n++
                listaClientes.add(fila.getString(0))
                fila.moveToNext()
            }
            val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaClientes)
            spinner.adapter=adaptador1

        } else {
            Toast.makeText(this, "No existe un Cliente con dicho nombre", Toast.LENGTH_SHORT).show()
        }
        
        n=0

        if (filaproductos.moveToFirst()) {
            while (n < filaproductos.count) {
                n++
                listaProductos.add(filaproductos.getString(0))
                fila.moveToNext()
            }
            val adaptador2 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaProductos)
            spinner2.adapter=adaptador2

        } else {
            Toast.makeText(this, "No existe un Producto con dicho nombre", Toast.LENGTH_SHORT).show()
        }


        bd.close()

        buton1.setOnClickListener {
            et1.setText("")
            Toast.makeText(this, "Venta Generada", Toast.LENGTH_SHORT).show()
        }

    }
}