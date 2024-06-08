package com.xicelow.ecoamigosevilla

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


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
            irCerrarP()
        }
    }
    private fun irMenuP(){
        val i = Intent(this, MenuActivity::class.java)
        startActivity(i)
    }

    private fun irCerrarP() {
        FirebaseAuth.getInstance().signOut()
        val i = Intent(this, LoginActivity::class.java)
        Toast.makeText(applicationContext, "Has Cerrado Sesión", Toast.LENGTH_SHORT).show()
        startActivity(i)
    }
}