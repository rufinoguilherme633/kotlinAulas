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

class Paralelepipedo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_paralelepipedo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val altura= findViewById<EditText>(R.id.velocidade_inicial)
        val largura= findViewById<EditText>(R.id.`aceleração`)
        val profundidade = findViewById<EditText>(R.id.deslocamento)
        val button = findViewById<Button>(R.id.resultado)

        val  result = findViewById<TextView>(R.id.resultado)


        button.setOnClickListener {
            try {

                var total = altura.text.toString().toDouble() * largura.text.toString().toDouble() * profundidade.text.toString().toDouble()
                result.text = total.toString()

            }catch (e: Exception){

                Toast.makeText(this, "Digite um valor válido", Toast.LENGTH_SHORT).show()
            }
        }

    }
}