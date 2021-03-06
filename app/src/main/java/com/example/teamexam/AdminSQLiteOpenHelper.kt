package com.example.teamexam

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory

class AdminSQLiteOpenHelper(context: Context, name: String, factory: CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table users(id int primary key, user text, password text, email text, store text)")
        db.execSQL("create table cliente(id int primary key, nombre text, direccion text, telefono text, email text, encargado text)")
        db.execSQL("create table productos(id int primary key, nombre text, descripcion text, cantidad int, precio float, url text, encargado text)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}