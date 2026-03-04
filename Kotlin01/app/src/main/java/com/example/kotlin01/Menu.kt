package com.example.kotlin01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val energia= findViewById<Button>(R.id.energia)
        val velocidade= findViewById<Button>(R.id.velocidade)
        val forca= findViewById<Button>(R.id.forca)


        energia.setOnClickListener {
            val i1 = Intent(this, appEnergia::class.java)
            startActivity(i1)
        }
        velocidade.setOnClickListener {
            val i1 = Intent(this, appVelocidade::class.java)
            startActivity(i1)
        }
        forca.setOnClickListener {
            val i1 = Intent(this, appForca::class.java)
            startActivity(i1)
            finish()
        }
    }
}