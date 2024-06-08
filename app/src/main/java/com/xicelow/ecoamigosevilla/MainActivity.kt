package com.xicelow.ecoamigosevilla

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    var firebaseUser : FirebaseUser?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pulsaIniciar = findViewById<TextView>(R.id.pulsaI)
        pulsaIniciar.setOnClickListener{
            Iniciar()
        }
    }
    private fun Iniciar(){
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
    }
    private fun ComprobarSesion(){
        firebaseUser = FirebaseAuth.getInstance().currentUser
        if (firebaseUser!= null){
            val intent = Intent(this, InicioActivity::class.java)
            Toast.makeText(applicationContext, "La Sesión Está Activa", Toast.LENGTH_SHORT).show()
            startActivity(intent)
            finish()
        }
    }
    override fun onStart() {
        ComprobarSesion()
        super.onStart()
    }
}