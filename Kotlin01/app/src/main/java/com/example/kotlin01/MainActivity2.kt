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

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val campo1= findViewById<EditText>(R.id.edt1)
        val campo2= findViewById<EditText>(R.id.edt2)
        val resultado = findViewById<TextView>(R.id.txtresult)
        val botaoSoma = findViewById<Button>(R.id.botaoSoma)


       botaoSoma.setOnClickListener {
           try {
               val v1 = campo1.text.toString().toDouble()
               val v2 = campo2.text.toString().toDouble()
               var total = v1 + v2
               resultado.text = total.toString()

           }catch (e: Exception){

               Toast.makeText(this, "Digite um valor válido", Toast.LENGTH_SHORT).show()
           }
       }
    }
}