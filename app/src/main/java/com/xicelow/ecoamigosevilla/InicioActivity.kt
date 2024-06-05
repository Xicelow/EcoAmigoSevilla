package com.xicelow.ecoamigosevilla

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val irAPerfilI = findViewById<ImageButton>(R.id.imageButtonPI)
        irAPerfilI.setOnClickListener{
            irPerfilI()
        }
        val irAMenuI = findViewById<ImageButton>(R.id.imageButtonMI)
        irAMenuI.setOnClickListener{
            irMenuI()
        }
    }
    private fun irPerfilI(){
        val i = Intent(this, PerfilActivity::class.java)
        startActivity(i)
    }
    private fun irMenuI(){
        val i = Intent(this, MenuActivity::class.java)
        startActivity(i)
    }
}