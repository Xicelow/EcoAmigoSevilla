package com.xicelow.ecoamigosevilla

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class PerfilActivity : AppCompatActivity() {

    val CambiarFotoP = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){ uri ->
        if(uri!=null){
            Toast.makeText(applicationContext, "Imagen de Perfil Cambiada", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(applicationContext, "La Imagen de Perfil no Fue Seleccionada", Toast.LENGTH_SHORT) .show()
        }
    }

    lateinit var imagenPerfil: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        imagenPerfil = findViewById(R.id.imagenPerfil)
        imagenPerfil.setOnClickListener{
            CambiarFotoP.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

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