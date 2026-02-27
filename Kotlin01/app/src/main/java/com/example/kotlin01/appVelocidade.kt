package com.example.kotlin01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class appVelocidade : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.app_velocidade)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val distancia = findViewById<EditText>(R.id.massa)
        val tempo = findViewById<EditText>(R.id.aceleracao)
        val button_calcular =  findViewById<Button>(R.id.calculo)
        val resultado = findViewById<TextView>(R.id.resultado)



        button_calcular.setOnClickListener {

            try {
                val distancia_double = distancia.text.toString().toDouble()
                val tempo_double = tempo.text.toString().toDouble()
                val result = distancia_double / tempo_double
                resultado.text = result.toString()
            } catch (e: Exception) {
                Toast.makeText(this, "Digite um valor válido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}