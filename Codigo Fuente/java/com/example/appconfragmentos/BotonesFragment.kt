package com.example.appconfragmentos

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class BotonesFragment : Fragment() {

    private lateinit var container: LinearLayout
    private val boredApeList = mutableListOf(
        BoredApe(27804, "20"),
        BoredApe(37805, "21"),
        BoredApe(27884, "22"),
        BoredApe(84230, "23"),
        BoredApe(33804, "24"),
        BoredApe(37705, "25"),
        BoredApe(21864, "26"),
        BoredApe(27260, "27"),
        BoredApe(28800, "28"),
        BoredApe(80800, "29"),
        BoredApe(21822, "30"),
        BoredApe(77830, "31"),
        BoredApe(32855, "32"),
        BoredApe(99704, "33"),
        BoredApe(81829, "34"),
        BoredApe(97211, "35"),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_botones, container, false)

        this.container = view.findViewById(R.id.container)

        // listado
        cargarBoredApes()

        // botones
        val agregar = view.findViewById<Button>(R.id.btnAgregar)
        val editar = view.findViewById<Button>(R.id.btnEditar)
        val buscar = view.findViewById<Button>(R.id.btnBuscar)
        val refrescar = view.findViewById<Button>(R.id.btnRefrescar)


        agregar.setOnClickListener {
            mostrarDialogoInput("Agregar Bored Ape", "Ingrese la Info del Bored Ape (ej., 1234, 20)") { input ->
                val partes = input.split(",").map { it.trim() }
                if (partes.size == 2) {
                    val numero = partes[0].toIntOrNull()
                    val style = partes[1]
                    if (numero != null && style.isNotEmpty()) {
                        val nuevoBoredApe = BoredApe(numero, style)
                        boredApeList.add(nuevoBoredApe)
                        agregarBoredApeView(nuevoBoredApe)
                        mostrarToast("Bored Ape Agregado")
                    } else {
                        mostrarToast("Invalido. Ingrese un numero y estilo")
                    }
                } else {
                    mostrarToast("Por Favor Ingrese un numero y estilo")
                }
            }
        }

        editar.setOnClickListener {
            if (boredApeList.isNotEmpty()) {
                mostrarDialogoDeSelecion("Seleccione el  Bored Ape a Editar", boredApeList.map { "Bored Ape ${it.numero} - Estilo ${it.estilo}" }) { selectedIndex ->
                    mostrarDialogoInput("Editar Bored Ape", "Ingrese nuevo estilo para Bored Ape ${boredApeList[selectedIndex].numero}") { nuevoEstilo ->
                        boredApeList[selectedIndex] = BoredApe(boredApeList[selectedIndex].numero, nuevoEstilo)
                        refrescarList()
                        mostrarToast("Bored Ape Actualizado")
                    }
                }
            } else {
                mostrarToast("No hay Bored Apes para editar")
            }
        }

        buscar.setOnClickListener {
            mostrarDialogoInput("Buscar Bored Apes", "Ingrese estilo (ej., 4)") { query ->
                val listaFiltrada = boredApeList.filter {
                    it.numero.toString().contains(query) || it.estilo.contains(query, ignoreCase = true)
                }
                refrescarList(listaFiltrada)
            }
        }

        refrescar.setOnClickListener {
            refrescarList()
        }

        return view
    }

    private fun cargarBoredApes() {
        boredApeList.forEach { agregarBoredApeView(it) }
    }

    private fun agregarBoredApeView(boredApe: BoredApe) {
        val textView = TextView(context).apply {
            text = "Bored Ape ${boredApe.numero} - Estilo ${boredApe.estilo}"
            textSize = 16f
            setPadding(8, 8, 8, 8)
        }
        container.addView(textView)
    }

    private fun refrescarList(nuevaLista: List<BoredApe> = boredApeList) {
        container.removeAllViews()
        nuevaLista.forEach { agregarBoredApeView(it) }
    }

    private fun mostrarToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun mostrarDialogoInput(title: String, hint: String, callback: (String) -> Unit) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)

        val input = EditText(context)
        input.hint = hint
        builder.setView(input)

        builder.setPositiveButton("OK") { dialog, _ ->
            val userInput = input.text.toString()
            if (userInput.isNotEmpty()) {
                callback(userInput)
            } else {
                mostrarToast("No puede estar vacio")
            }
            dialog.dismiss()
        }
            builder.setNegativeButton("Cancelar") { dialog, _ -> dialog.cancel() }

        builder.show()
    }

    private fun mostrarDialogoDeSelecion(title: String, items: List<String>, callback: (Int) -> Unit) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)

        builder.setItems(items.toTypedArray()) { dialog, which ->
            callback(which)
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancelar") { dialog, _ -> dialog.cancel() }

        builder.show()
    }
}

data class BoredApe(val numero: Int, val estilo: String)
