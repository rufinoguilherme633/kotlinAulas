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

class CelsiusFahrenheit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_celsius_fahrenheit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val valor_celso = findViewById<EditText>(R.id.valor_celso)
        val button = findViewById<Button>(R.id.resultado)
        val resultado = findViewById<TextView>(R.id.resultado)


        button.setOnClickListener {

            try {
                val result = (valor_celso.text.toString().toDouble() *9 / 5) + 32

                resultado.text =result.toString()

            }catch (e : Exception){
                Toast.makeText(this, "Digite um valor válido", Toast.LENGTH_SHORT).show()
                print(e)
            }
        }

    }
}