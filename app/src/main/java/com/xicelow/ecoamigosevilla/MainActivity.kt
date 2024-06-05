package com.xicelow.ecoamigosevilla

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pulsaIniciar = findViewById<TextView>(R.id.pulsaI)
        pulsaIniciar.setOnClickListener{
            irPulsar()
        }
    }
    private fun irPulsar(){
        val i = Intent(this, LoginActivity::class.java)
        startActivity(i)
    }
}