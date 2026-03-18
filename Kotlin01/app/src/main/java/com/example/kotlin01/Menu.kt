package com.example.kotlin01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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
        val fahrenheitCelsius= findViewById<Button>(R.id.fahrenheitCelsius)
        val paralelepipedo = findViewById<Button>(R.id.paralelepipedo)
        val celsiusFahrenheit= findViewById<Button>(R.id.celsiusFahrenheit)
        val nome = findViewById<TextView>(R.id.nome)
        val torreli= findViewById<Button>(R.id.map)
        val map= findViewById<Button>(R.id.map)
        energia.setOnClickListener {
            val i1 = Intent(this, appEnergia::class.java).apply {
                var name = nome?.text?.toString() ?: ""
                putExtra(appEnergia.EXTRA_NOME,name)
            }
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

        fahrenheitCelsius.setOnClickListener {
            val i1 = Intent(this, FahrenheitCelsius::class.java)
            startActivity(i1)
            finish()
        }

        celsiusFahrenheit.setOnClickListener {
            val i1 = Intent(this, CelsiusFahrenheit::class.java)
            startActivity(i1)
            finish()
        }
        paralelepipedo.setOnClickListener {
            val i1 = Intent(this, Paralelepipedo::class.java)
            startActivity(i1)
            finish()
        }

        torreli.setOnClickListener {
            val i1 = Intent(this, Torricelli::class.java)
            startActivity(i1)
            finish()
        }
        map.setOnClickListener {
            val i1 = Intent(this, Map::class.java)
            startActivity(i1)
            finish()
        }
    }
}