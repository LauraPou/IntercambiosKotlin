package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CrearCuenta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.crear_cuenta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textNombre: EditText = findViewById(R.id.editTextNombre)
        val textAlias: EditText = findViewById(R.id.editTextAlias)
        val textCorreo: EditText = findViewById(R.id.editTextCorreo)
        val textContrasena: EditText = findViewById(R.id.editTextPassword)
        val buttonRegistrar: Button = findViewById(R.id.buttonRegistrar)

        buttonRegistrar.setOnClickListener {
            val nombre = textNombre.text.toString()
            val alias = textAlias.text.toString()
            val correo = textCorreo.text.toString()
            val password = textContrasena.text.toString()

            if (nombre.isNotEmpty() && correo.isNotEmpty() && password.isNotEmpty()) {
                // Crear un Intent para enviar los datos a LoginActivity
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Nombre", nombre)
                intent.putExtra("Alias", alias)
                intent.putExtra("Correo", correo)
                intent.putExtra("Password", password)
                startActivity(intent)

                // Cerrar esta actividad para volver a Login
                finish()
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}