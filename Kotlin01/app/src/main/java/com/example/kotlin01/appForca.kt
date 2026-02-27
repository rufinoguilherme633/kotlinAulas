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

class appForca : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.app_forca)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val aceleracao= findViewById<EditText>(R.id.aceleracao)
        val massa= findViewById<EditText>(R.id.massa)
        val resultado = findViewById<TextView>(R.id.resultado)
        val botaoSoma = findViewById<Button>(R.id.calculo)


        botaoSoma.setOnClickListener {
            try {
                val v1 = aceleracao.text.toString().toDouble()
                val v2 = massa.text.toString().toDouble()
                var total = v1 * v2
                resultado.text = total.toString()

            }catch (e: Exception){

                Toast.makeText(this, "Digite um valor válido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}