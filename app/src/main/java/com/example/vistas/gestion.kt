package com.example.vistas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Clase principal
class Gestion : AppCompatActivity() {

    // Método que se ejecuta al crear la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gestion)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar el botón para eliminar cuenta.
        val btnEliminarCuenta: Button = findViewById(R.id.btn_eliminar_cuenta)
        btnEliminarCuenta.setOnClickListener {
            eliminarCuenta()
        }

        // Configurar el botón de volver atrás.
        val btnVolverAtras: Button = findViewById(R.id.btn_volver_atras)
        btnVolverAtras.setOnClickListener {
            val intent = Intent(this, ControlDispositivo::class.java)
            startActivity(intent)
            finish() // Cierra la actividad actual
        }
    }

    // Función para eliminar la cuenta del usuario.
    private fun eliminarCuenta() {
        // Eliminar datos del usuario de las preferencias compartidas.
        val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            clear()
            apply()
        }
        Toast.makeText(this, "Tu cuenta ha sido eliminada", Toast.LENGTH_SHORT).show()
        // Redirigir a la actividad de inicio de sesión o inicio.
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Cierra la actividad actual
    }
}
