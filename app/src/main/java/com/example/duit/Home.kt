package com.example.duit

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Home : AppCompatActivity() {

    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        val nameTv
        val name = preferences.getString("NAME", "")
        nameTv.text = name


    }
}