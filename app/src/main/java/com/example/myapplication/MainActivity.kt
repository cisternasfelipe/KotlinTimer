package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import android.os.Handler
import android.os.Looper


class MainActivity : AppCompatActivity() {
    private lateinit var txtFecha: TextView
    private lateinit var txtHora: TextView

    private val handler = Handler(Looper.getMainLooper())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtFecha = findViewById<TextView>(R.id.tvDate)
        txtHora = findViewById<TextView>(R.id.tvTime)

        handler.post(tareaReloj)
    }

    private val tareaReloj = object : Runnable {
        override fun run() {
            actualizarPantalla()
            handler.postDelayed(this, 1000)
        }
    }

    private fun actualizarPantalla() {
        val ahora = Calendar.getInstance().time
        val fmtFecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val fmtHora = SimpleDateFormat("HH:mm:ss", Locale.getDefault())

        txtFecha.text = fmtFecha.format(ahora)
        txtHora.text = fmtHora.format(ahora)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(tareaReloj)
    }
}
