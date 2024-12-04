package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PaginaInicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.pagina_incio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonEditarIntercambios: Button = findViewById(R.id.editar_intercambios)
        buttonEditarIntercambios.setOnClickListener {
            val intent = Intent(this, EditarIntercambios::class.java)
            startActivity(intent)
        }
        val buttonConsultarIntercambios: Button = findViewById(R.id.consultar_intercambios)
        buttonConsultarIntercambios.setOnClickListener {
            val intent = Intent(this, EditarIntercambios::class.java)
            startActivity(intent)
        }
        val buttonIngresarIntercambios: Button = findViewById(R.id.ingresar_a_intercambio)
        buttonIngresarIntercambios.setOnClickListener {
            val intent = Intent(this, EditarIntercambios::class.java)
            startActivity(intent)
        }
        val buttonIntercambiosParticipantes: Button = findViewById(R.id.intercambios_participantes)
        buttonIntercambiosParticipantes.setOnClickListener {
            val intent = Intent(this, EditarIntercambios::class.java)
            startActivity(intent)
        }


    }

}