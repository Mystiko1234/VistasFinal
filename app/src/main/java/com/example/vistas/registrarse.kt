package com.example.vistas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Registrarse : AppCompatActivity() {
    // Declaración de las variables para los campos de entrada
    private lateinit var username: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el diseño de la actividad
        setContentView(R.layout.activity_registrarse)

        // Inicializa los campos de entrada
        username = findViewById(R.id.username)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        confirmPassword = findViewById(R.id.confirm_password)

        // Inicializa el botón de registro y establece un listener
        val btnRegister: Button = findViewById(R.id.btn_register)
        btnRegister.setOnClickListener { registerUser() }

        // Inicializa el botón de regresar a la pantalla de inicio de sesión
        val btnBackToLogin: Button = findViewById(R.id.btn_back_to_login)
        btnBackToLogin.setOnClickListener {
            // Inicia la actividad de inicio de sesión y finaliza esta actividad
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    // Método para registrar al usuario
    private fun registerUser() {
        // Obtiene los datos de los campos de entrada
        val user = username.text.toString().trim()
        val mail = email.text.toString().trim()
        val pass = password.text.toString().trim()
        val confirmPass = confirmPassword.text.toString().trim()

        // Verifica si todos los campos están llenos
        if (user.isEmpty() || mail.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
            Toast.makeText(this, "Completa todos los campos.", Toast.LENGTH_SHORT).show()
            return
        }

        // Valida el formato del correo electrónico
        if (!isEmailValid(mail)) {
            Toast.makeText(this, "Por favor, ingresa un correo válido.", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            // Guarda los datos del usuario en SharedPreferences
            val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putString("username", user)
                putString("email", mail)
                putString("password", pass)
                apply()
            }
            // Muestra un mensaje de éxito y regresa a la actividad principal
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } catch (e: Exception) {
            // Maneja cualquier error que ocurra durante el registro
            Toast.makeText(this, "Error al registrar usuario.", Toast.LENGTH_SHORT).show()
        }
    }

    // Método para validar el formato del correo electrónico
    private fun isEmailValid(email: String): Boolean {
        return email.contains("@") && email.contains(".")
    }
}
