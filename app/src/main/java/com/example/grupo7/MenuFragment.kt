package com.example.grupo7// java/com/ejemplo/portafoliopersonal/MenuFragment.kt
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import java.lang.ClassCastException

// La clase hereda de Fragment y usa el layout que creamos
class MenuFragment : Fragment(R.layout.fragment_menu) {

    // Define una interfaz para comunicarse con la Activity. Es un contrato.
    // La Activity que contenga este fragmento DEBE implementar esta interfaz.
    interface OnOptionClickListener {
        fun onOptionClicked(option: String)
    }

    private var listener: OnOptionClickListener? = null

    // Este método se llama justo después de que la vista del fragmento ha sido creada.
    override fun onViewCreated(view: View  , savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Se comprueba si la Activity contenedora implementa la interfaz de comunicación.
        if (context is OnOptionClickListener) {
            listener = context as OnOptionClickListener
        } else {
            // Si no la implementa, lanza un error para avisar al desarrollador.
            throw ClassCastException("$context must implement OnOptionClickListener")
        }
    }
}