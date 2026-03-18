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

class Diluicao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diluicao)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val v1 = findViewById<EditText>(R.id.v1)
        val c1 = findViewById<EditText>(R.id.c1)
        val c2 = findViewById<EditText>(R.id.c2)
        val button = findViewById<Button>(R.id.resultado)
        val result = findViewById<TextView>(R.id.resultado)


        button.setOnClickListener {

            try {
                val resultado = v1.text.toString().toDouble() * c1.text.toString().toDouble() / c2.text.toString().toDouble()
                result.text = resultado.toString()
            }catch (e: Exception){
                Toast.makeText(this, "Digite um valor válido", Toast.LENGTH_SHORT).show()

            }
        }
    }
}