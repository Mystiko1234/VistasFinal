package com.example.vistas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.Toast
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Opciones123 : AppCompatActivity() {

    // Variable para almacenar el color seleccionado por el usuario
    private var selectedColor: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones123)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar el SeekBar para ajustar el brillo
        val seekBarBrillo = findViewById<SeekBar>(R.id.btnBrillo)
        seekBarBrillo.max = 100 // Establecer el rango del SeekBar
        seekBarBrillo.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Mostrar un mensaje de confirmación al dejar de ajustar el SeekBar
                Toast.makeText(this@Opciones123, "Se cambió correctamente el brillo", Toast.LENGTH_SHORT).show()
            }
        })

        // Configurar el SeekBar para ajustar el temporizador
        val seekBarTemporizador = findViewById<SeekBar>(R.id.Seektemporizador)
        seekBarTemporizador.max = 100 // Establecer el rango del SeekBar
        seekBarTemporizador.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Mostrar un mensaje de confirmación al dejar de ajustar el SeekBar
                Toast.makeText(this@Opciones123, "Temporizador ajustado a ${seekBar?.progress}", Toast.LENGTH_SHORT).show()
            }
        })

        // Asignar click listener a los botones de color
        findViewById<View>(R.id.color_rojo).setOnClickListener { selectColor("#FF0000", "rojo") }
        findViewById<View>(R.id.color_verde).setOnClickListener { selectColor("#00FF00", "verde") }
        findViewById<View>(R.id.color_azul).setOnClickListener { selectColor("#0000FF", "azul") }
        findViewById<View>(R.id.color_amarillo).setOnClickListener { selectColor("#FFFF00", "amarillo") }
        findViewById<View>(R.id.color_cian).setOnClickListener { selectColor("#00FFFF", "cian") }

        // Asignar click listener al botón para aplicar el color seleccionado
        findViewById<Button>(R.id.btnaplicar_color).setOnClickListener {
            aplicarColor()
        }

        // Botón para volver a la pantalla anterior
        findViewById<Button>(R.id.bntControlManual).setOnClickListener {
            fnCambiarPantalla()
        }

        // Botón para cambiar a Control Manual
        findViewById<Button>(R.id.btnVolveatras).setOnClickListener {
            fnCambiarPantalla1()
        }
    }

    // Método para cambiar a la actividad de ControlDispositivo
    private fun fnCambiarPantalla1() {
        val intent = Intent(this, ControlDispositivo::class.java)
        startActivity(intent)
    }

    // Método para cambiar a la actividad Opciones
    private fun fnCambiarPantalla() {
        val intent = Intent(this, Opciones::class.java)
        startActivity(intent)
    }

    // Método para seleccionar un color
    private fun selectColor(color: String, colorName: String) {
        selectedColor = color // Asigna el color seleccionado
        Toast.makeText(this, "Color seleccionado: $colorName", Toast.LENGTH_SHORT).show() // Muestra el color seleccionado
    }

    // Método para aplicar el color seleccionado
    private fun aplicarColor() {
        // Determina el mensaje basado en el color seleccionado
        val colorMessage = when (selectedColor) {
            "#FF0000" -> "Se ha cambiado a rojo"
            "#00FF00" -> "Se ha cambiado a verde"
            "#0000FF" -> "Se ha cambiado a azul"
            "#FFFF00" -> "Se ha cambiado a amarillo"
            "#00FFFF" -> "Se ha cambiado a cian"
            else -> "No se ha seleccionado ningún color"
        }
        // Muestra el mensaje cuando se aplica el color
        Toast.makeText(this, colorMessage, Toast.LENGTH_SHORT).show()
    }
}
