package com.example.relativelayout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity5 : AppCompatActivity() {
    var btn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn = findViewById(R.id.btnSIGNIN)
        btn?.setOnClickListener {
            Toast.makeText(this, "on click message displayer", Toast.LENGTH_SHORT).show()
            var intent = Intent(
                this, MainActivity6
                ::class.java
            )
            startActivity(intent)
        }
        btn = findViewById(R.id.btnSIGNUP)
        btn?.setOnClickListener {
            Toast.makeText(this, "on click message displayer", Toast.LENGTH_SHORT).show()
            var intent = Intent(
                this, MainActivity7
                ::class.java
            )
            startActivity(intent)
        }
    }
}