package com.example.proyectofinal


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.widget.Toolbar


class EditarIntercambios: AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_intercambios)

        // Configurar Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configurar DrawerLayout y NavigationView
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)

        // Configurar el toggle para abrir y cerrar el drawer
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Manejar clics en el menú
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_editar_intercambios -> {
                    // Redirigir a la actividad de editar intercambios
                    val intent = Intent(this, EditarIntercambios::class.java)
                    startActivity(intent)
                }
                R.id.nav_intercambios_creados -> {
                    // Redirigir a la actividad de intercambios creados
                    val intent = Intent(this, ConsultarIntercambios::class.java)
                    startActivity(intent)
                }
                R.id.nav_ingresar_intercambio -> {
                    // Redirigir a la actividad de ingresar intercambio
                    val intent = Intent(this, PaginaInicio::class.java)
                    startActivity(intent)
                }
                R.id.nav_mis_intercambios -> {
                    // Redirigir a la actividad de mis intercambios
                    val intent = Intent(this, IntercambiosParticipantes::class.java)
                    startActivity(intent)
                }
            }
            drawerLayout.closeDrawers() // Cierra el Navigation Drawer después de seleccionar un item
            true
        }

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
