package com.example.kotlin01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class appEnergia : AppCompatActivity() {

    companion object{
        const val EXTRA_NOME = "EXTRA_NOME"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val nomeRecebido = intent.getStringExtra(EXTRA_NOME)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_energia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val massa = findViewById<EditText>(R.id.massa)
        val velocidade = findViewById<EditText>(R.id.velocidade)
        val button_calcular = findViewById<Button>(R.id.calcular)
        val resultado = findViewById<TextView>(R.id.resultado)
        val usur = findViewById<TextView>(R.id.usuario)



        usur.text = nomeRecebido?:""
        button_calcular.setOnClickListener {

            try {
                val massa_text = massa.text.toString().toDouble()
                val velocidade_text = velocidade.text.toString().toDouble()

                val result = (massa_text * velocidade_text.pow(2)) /2
                AlertDialog.Builder(this)
                    .setTitle("Resultado")
                    .setMessage(result.toString())
                    .setPositiveButton("ok",null)
                    .show()


                //resultado.text = result.toString()
        }catch (e: Exception){
                Toast.makeText(this, "Digite um valor válido", Toast.LENGTH_SHORT).show()
        }
        }
    }
}