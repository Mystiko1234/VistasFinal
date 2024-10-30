package com.example.vistas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// Clase principal.
class MainActivity : AppCompatActivity() {
    // Variables para almacenar las referencias de los campos de entrada de correo electrónico y contraseña.
    private lateinit var email: EditText
    private lateinit var password: EditText

    // Método que se llama al crear la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa las variables de los campos de entrada utilizando sus id.
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)

        // Configura el botón de inicio de sesión para que ejecute la función loginUser() al ser presionado.
        val btnLogin: Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener { loginUser() }

        // Configura el botón de registro para iniciar la actividad de registro al ser presionado.
        val btnRegistro: Button = findViewById(R.id.btn_registro)
        btnRegistro.setOnClickListener {
            startActivity(Intent(this, Registrarse::class.java))
        }
    }

    // Método que maneja el proceso de inicio de sesión.
    private fun loginUser() {
        // Obtiene los textos ingresados en los campos de correo y contraseña, eliminando espacios innecesarios.
        val inputEmail = email.text.toString().trim()
        val inputPassword = password.text.toString().trim()

        // Verifica que los campos de correo y contraseña no estén vacíos.
        if (inputEmail.isEmpty() || inputPassword.isEmpty()) {
            // Muestra un mensaje si los campos están vacíos.
            Toast.makeText(this, "Completa todos los campos.", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            // Accede a las preferencias compartidas para obtener las credenciales almacenadas del usuario.
            val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
            val savedEmail = sharedPreferences.getString("email", "")
            val savedPassword = sharedPreferences.getString("password", "")

            // Verifica si las credenciales ingresadas coinciden con las almacenadas.
            if (inputEmail == savedEmail && inputPassword == savedPassword) {
                // Muestra un mensaje de éxito y navega a la siguiente actividad si las credenciales son correctas.
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ControlDispositivo::class.java))
                finish() // Finaliza la actividad actual para evitar volver a ella.
            } else {
                // Muestra un mensaje de error si los datos son incorrectos.
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            // Maneja excepciones y muestra un mensaje de error en caso de problemas al iniciar sesión.
            Toast.makeText(this, "Error al iniciar sesión.", Toast.LENGTH_SHORT).show()
        }
    }
}
