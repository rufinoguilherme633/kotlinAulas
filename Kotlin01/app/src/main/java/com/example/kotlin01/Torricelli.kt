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
import kotlin.math.pow

class Torricelli : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_torricelli)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val velocidade_inicial= findViewById<EditText>(R.id.velocidade_inicial)
        val aceleração= findViewById<EditText>(R.id.aceleração)
        val deslocamento = findViewById<TextView>(R.id.deslocamento)
        val button = findViewById<Button>(R.id.resultado)

        val resultado = findViewById<TextView>(R.id.resultado)

        button.setOnClickListener {
            try {

                val r = velocidade_inicial.text.toString().toDouble().pow(2.0) + 2 * aceleração.text.toString().toDouble() * deslocamento.text.toString().toDouble()
                resultado.text = r.toString()
            }catch (e: Exception){

                Toast.makeText(this, "Digite um valor válido", Toast.LENGTH_SHORT).show()
            }
        }

    }
}