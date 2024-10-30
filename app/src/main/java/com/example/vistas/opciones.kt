package com.example.vistas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Clase principal
class Opciones : AppCompatActivity() {

    // Método que se ejecuta al crear la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_opciones)

        // Configura los márgenes de los elementos para evitar que se superpongan con las barras del sistema.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializa los botones de la interfaz de usuario.
        val btnCambiarPantalla: Button = findViewById(R.id.buttonMenu)  // Botón para cambiar de pantalla.
        val btnEncender: Button = findViewById(R.id.buttonEncender)  // Botón para encender la luz.
        val btnApagar: Button = findViewById(R.id.buttonApagar)  // Botón para apagar la luz.

        // Asignar un evento al botón para cambiar de pantalla.
        btnCambiarPantalla.setOnClickListener {
            fnCambiarPantalla()
        }

        // Asignar un evento al botón de encender.
        btnEncender.setOnClickListener {
            Toast.makeText(this, "La luz ha sido encendida", Toast.LENGTH_SHORT).show()
        }

        // Asignar un evento al botón de apagar.
        btnApagar.setOnClickListener {
            Toast.makeText(this, "La luz ha sido apagada", Toast.LENGTH_SHORT).show()
        }
    }

    // Función para cambiar a la actividad Opciones123.
    private fun fnCambiarPantalla() {
        val intent = Intent(this, Opciones123::class.java)
        startActivity(intent)
    }
}
