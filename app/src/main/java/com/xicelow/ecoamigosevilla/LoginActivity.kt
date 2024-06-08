package com.xicelow.ecoamigosevilla

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class LoginActivity : AppCompatActivity() {

    private lateinit var correoInicio : EditText
    private lateinit var contrasenaInicio : EditText
    private lateinit var btnIngresar : Button
    private lateinit var irARegister : TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        InicializarVariables()

        btnIngresar.setOnClickListener{
            ValidarDatos()
        }
        irARegister.setOnClickListener{
            irRegister()
        }
    }
    private fun InicializarVariables(){
        correoInicio = findViewById(R.id.correoInicio)
        contrasenaInicio = findViewById(R.id.contrasenaInicio)
        btnIngresar = findViewById(R.id.btnIngresar)
        irARegister = findViewById(R.id.irRegister)
        auth = FirebaseAuth.getInstance()
    }

    private fun ValidarDatos(){
        val I_Correo : String = correoInicio.text.toString()
        val I_Contrasena : String = contrasenaInicio.text.toString()

        if (I_Correo.isEmpty()){
            Toast.makeText(applicationContext, "Ingrese su Correo Electrónico", Toast.LENGTH_SHORT).show()
        }
        if (I_Contrasena.isEmpty()){
            Toast.makeText(applicationContext, "Ingrese su Contraseña", Toast.LENGTH_SHORT).show()
        }
        else{
            LoginUsuario(I_Correo, I_Contrasena)
        }
    }

    private fun LoginUsuario(I_Correo : String, I_Contrasena : String){
        auth.signInWithEmailAndPassword(I_Correo, I_Contrasena)
           .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, InicioActivity::class.java)
                    Toast.makeText(applicationContext, "Ha Iniciado Sesión Correctamente", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(applicationContext, "Error al Iniciar Sesión", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener {
                Toast.makeText(applicationContext, "${it.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun irRegister(){
        val i = Intent(this, RegisterActivity::class.java)
        startActivity(i)
    }
}