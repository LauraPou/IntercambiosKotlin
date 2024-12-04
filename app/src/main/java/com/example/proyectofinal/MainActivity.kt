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

class MainActivity : AppCompatActivity() {
    private var correoRegistrado: String? = null
    private var passwordRegistrado: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val usuario: EditText = findViewById(R.id.editTextCorreo)
        val contrasena: EditText = findViewById(R.id.editTextTextPassword)
        val buttonLogin: Button = findViewById(R.id.buttonLogIn)

        buttonLogin.setOnClickListener {
            val username = usuario.text.toString()
            val password = contrasena.text.toString()

            if (username == "pou" && password == "1234" || (username == correoRegistrado && password == passwordRegistrado )) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, PaginaInicio::class.java)
                startActivity(intent)

                // Una vez iniciada la sesión se supone que ya no puede regresar a la página del login
                finish()
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        val buttonCrearCuenta: Button = findViewById(R.id.buttonCrearCuenta)
        correoRegistrado = intent.getStringExtra("Correo")
        passwordRegistrado = intent.getStringExtra("Password")

        buttonCrearCuenta.setOnClickListener {
            val intent = Intent(this, CrearCuenta::class.java)
            startActivity(intent)
        }
    }
}