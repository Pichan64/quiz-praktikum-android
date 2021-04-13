package com.example.duit

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        isRemembered = sharedPreferences.getBoolean("CHECKBOX", false)

        if (isRemembered) {

            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        }

        val login = findViewById(R.id.login) as Button

        login.setOnClickListener {
            val nameEt
            val passEt
            val checkBox
            val name: String = nameEt.text.toString()
            val password: String = passEt.text.toString()
            val checked: Boolean = checkBox.isChecked()

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("NAME", name)
            editor.putString("PASSWORD", password)
            editor.putBoolean("CHECKBOX", checked)
            editor.apply()

            Toast.makeText(this, "Information Saved", Toast.LENGTH_LONG).show()

            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        }
    }
}