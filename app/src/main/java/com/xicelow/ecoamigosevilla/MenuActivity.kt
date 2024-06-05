package com.xicelow.ecoamigosevilla

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val irAInicioM = findViewById<Button>(R.id.btnInicio)
        irAInicioM.setOnClickListener{
            irInicioM()
        }
        val irAPerfilM = findViewById<Button>(R.id.btnPerfil)
        irAPerfilM.setOnClickListener{
            irPerfilM()
        }
    }
    private fun irInicioM(){
        val i = Intent(this, InicioActivity::class.java)
        startActivity(i)
    }
    private fun irPerfilM(){
        val i = Intent(this, PerfilActivity::class.java)
        startActivity(i)
    }
}