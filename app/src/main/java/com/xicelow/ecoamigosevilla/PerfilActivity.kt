package com.xicelow.ecoamigosevilla

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class PerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        val irAMenuP = findViewById<ImageButton>(R.id.imageButtonMP)
        irAMenuP.setOnClickListener{
            irMenuP()
        }
        val irCerrarP = findViewById<TextView>(R.id.cerrarSesion)
        irCerrarP.setOnClickListener{
        }
    }
    private fun irMenuP(){
        val i = Intent(this, MenuActivity::class.java)
        startActivity(i)
    }
}