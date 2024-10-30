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

class ControlDispositivo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Activa el modo de borde a borde
        setContentView(R.layout.activity_controldispositivo)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializa el botón para seleccionar un dispositivo
        val btnSeleccionarDispositivo: Button = findViewById(R.id.btn_seleccionar_dispositivo)
        btnSeleccionarDispositivo.setOnClickListener {
            Toast.makeText(this, "Se seleccionó un dispositivo", Toast.LENGTH_SHORT).show()
        }

        // Inicializa el botón para conectar un dispositivo
        val btnConectar: Button = findViewById(R.id.btn_conectar)
        btnConectar.setOnClickListener {
            Toast.makeText(this, "Se conectó un dispositivo", Toast.LENGTH_SHORT).show()
        }

        // Inicializa el botón para desconectar un dispositivo
        val btnDesconectar: Button = findViewById(R.id.btn_desconectar)
        btnDesconectar.setOnClickListener {
            Toast.makeText(this, "Se desconectó el dispositivo", Toast.LENGTH_SHORT).show()
        }

        // Inicializa el botón para ir al menú principal
        val btnCambiarPantalla: Button = findViewById(R.id.btn_ir_menu_principal)
        btnCambiarPantalla.setOnClickListener {
            fnCambiarPantalla()
        }

        // Inicializa el botón para volver al inicio de sesión
        val btnCambiarPantalla1: Button = findViewById(R.id.btn_volver_inicio)
        btnCambiarPantalla1.setOnClickListener {
            fnCambiarPantalla1()
        }

        // Nuevo botón para ir a la gestión de cuenta
        val btnGestionCuenta: Button = findViewById(R.id.btn_ir_gestion_cuenta)
        btnGestionCuenta.setOnClickListener {
            fnCambiarAPantallaGestion()
        }
    }

    // Método para cambiar a la pantalla de gestión de cuenta
    private fun fnCambiarAPantallaGestion() {
        val intent = Intent(this, Gestion::class.java)
        startActivity(intent)
    }

    // Método para cerrar sesión y volver a la pantalla de inicio
    private fun fnCambiarPantalla1() {
        val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE) // Obtiene las preferencias compartidas
        Toast.makeText(this, "Has cerrado sesión", Toast.LENGTH_SHORT).show()
        with(sharedPreferences.edit()) {
            putBoolean("is_logged_in", false) // Actualiza el estado de inicio de sesión
            apply() // Aplica los cambios
        }
        val intent = Intent(this, MainActivity::class.java) // Redirige a MainActivity
        startActivity(intent)
        finish() // Cierra la actividad de control de dispositivos
    }

    // Método para cambiar a la pantalla de opciones
    private fun fnCambiarPantalla() {
        val intent = Intent(this, Opciones123::class.java)
        startActivity(intent)
    }
}
