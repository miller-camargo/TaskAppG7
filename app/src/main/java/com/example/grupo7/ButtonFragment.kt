package com.example.grupo7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class ButtonFragment : Fragment() {

    private var counter = 0
    private var toggleActive = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_button, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvCounter = view.findViewById<TextView>(R.id.tv_counter)
        val tvToggle  = view.findViewById<TextView>(R.id.tv_toggle_status)
        val btnToggle = view.findViewById<MaterialButton>(R.id.btn_toggle)

        // 1. Filled
        view.findViewById<MaterialButton>(R.id.btn_filled).setOnClickListener {
            Toast.makeText(context, "Botón Filled presionado ✅", Toast.LENGTH_SHORT).show()
        }

        // 2. Outlined
        view.findViewById<MaterialButton>(R.id.btn_outlined).setOnClickListener {
            Toast.makeText(context, "Botón Outlined presionado 🔲", Toast.LENGTH_SHORT).show()
        }

        // 3. Text
        view.findViewById<MaterialButton>(R.id.btn_text).setOnClickListener {
            Toast.makeText(context, "Botón de Texto presionado 🔤", Toast.LENGTH_SHORT).show()
        }

        // 4. Ícono
        view.findViewById<MaterialButton>(R.id.btn_icon).setOnClickListener {
            Toast.makeText(context, "¡Compartiendo contenido! 📤", Toast.LENGTH_SHORT).show()
        }

        // 5. Toggle
        btnToggle.setOnClickListener {
            toggleActive = !toggleActive
            if (toggleActive) {
                tvToggle.text = "Estado: ACTIVADO"
                tvToggle.setTextColor(android.graphics.Color.parseColor("#22C55E"))
                btnToggle.text = "Desactivar Modo"
            } else {
                tvToggle.text = "Estado: DESACTIVADO"
                tvToggle.setTextColor(android.graphics.Color.parseColor("#EF4444"))
                btnToggle.text = "Activar Modo"
            }
        }

        // 6. Contador +
        view.findViewById<MaterialButton>(R.id.btn_increment).setOnClickListener {
            counter++
            tvCounter.text = counter.toString()
        }

        // 6. Contador −
        view.findViewById<MaterialButton>(R.id.btn_decrement).setOnClickListener {
            if (counter > 0) {
                counter--
                tvCounter.text = counter.toString()
            } else {
                Toast.makeText(context, "El contador no puede ser negativo", Toast.LENGTH_SHORT).show()
            }
        }

        // 6. Reiniciar
        view.findViewById<MaterialButton>(R.id.btn_reset).setOnClickListener {
            counter = 0
            tvCounter.text = "0"
            Toast.makeText(context, "Contador reiniciado 🔄", Toast.LENGTH_SHORT).show()
        }
    }
}
