package com.xicelow.ecoamigosevilla

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {
    private lateinit var nombre_usuario : EditText
    private lateinit var correoR : EditText
    private lateinit var contrasenaR : EditText
    private lateinit var confContrasenaR : EditText
    private lateinit var btnRegistrarte : Button

    private lateinit var auth: FirebaseAuth
    private lateinit var reference : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        InicializarVariables()

        btnRegistrarte.setOnClickListener {
            ValidarDatos()
        }
    }
    private fun InicializarVariables (){
        nombre_usuario = findViewById(R.id.nombre_usuario)
        correoR = findViewById(R.id.correoR)
        contrasenaR = findViewById(R.id.contrasenaR)
        confContrasenaR = findViewById(R.id.confContrasenaR)
        btnRegistrarte = findViewById(R.id.btnRegistrarte)
        auth = FirebaseAuth.getInstance()
    }

    private fun ValidarDatos(){
        val R_Nombre : String = nombre_usuario.text.toString()
        val R_Correo : String = correoR.text.toString()
        val R_Contrasena : String = contrasenaR.text.toString()
        val R_ConfContrasena : String = confContrasenaR.text.toString()

        if (R_Nombre.isEmpty()){
            Toast.makeText(applicationContext, "Ingrese su Nombre de Usuario a Registrar", Toast.LENGTH_SHORT).show()
        }
        else if (R_Correo.isEmpty()){
            Toast.makeText(applicationContext, "Ingrese su Correo a Registrar", Toast.LENGTH_SHORT).show()
        }
        else if (R_Contrasena.isEmpty()){
            Toast.makeText(applicationContext, "Ingrese su Contraseña a Registrar", Toast.LENGTH_SHORT).show()
        }
        else if (R_ConfContrasena.isEmpty()){
            Toast.makeText(applicationContext, "Confirme la Contraseña a Registrar", Toast.LENGTH_SHORT).show()
        }
        else if (!R_Contrasena.equals(R_ConfContrasena)){
            Toast.makeText(applicationContext, "Las Contraseñas no coinciden", Toast.LENGTH_SHORT).show()
        }
        else{
            RegistrarUsuario(R_Correo, R_Contrasena)
        }
    }

    private fun RegistrarUsuario(R_Correo : String, R_Contrasena : String){
        auth.createUserWithEmailAndPassword(R_Correo, R_Contrasena)
           .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    var uid : String = ""
                    uid = auth.currentUser!!.uid
                    reference = FirebaseDatabase.getInstance().reference.child("Usuarios").child(uid)

                    val hashMap = HashMap<String, Any>()
                    val h_nombre_usuario : String = nombre_usuario.text.toString()
                    val h_correoR : String = correoR.text.toString()

                    hashMap["uid"] = uid
                    hashMap["n_usuario"] = h_nombre_usuario
                    hashMap["correo"] = h_correoR
                    hashMap["imagen"] = ""
                    hashMap["buscar"] = h_nombre_usuario.lowercase()

                    reference.updateChildren(hashMap).addOnCompleteListener { task2 ->
                        if (task2.isSuccessful){
                            val intent = Intent(this, LoginActivity::class.java)
                            Toast.makeText(applicationContext, "Se ha registrado con éxito", Toast.LENGTH_SHORT).show()
                            startActivity(intent)
                        }
                    }
                        .addOnFailureListener { e ->
                        Toast.makeText(applicationContext, "${e.message}", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(applicationContext, "No se ha podido registrar", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { e ->
                Toast.makeText(applicationContext, "${e.message}", Toast.LENGTH_SHORT).show()
            }
    }
}