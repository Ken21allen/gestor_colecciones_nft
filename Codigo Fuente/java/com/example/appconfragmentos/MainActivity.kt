package com.example.appconfragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btnPerfil).setOnClickListener {
            mostrarFragmento(
                InfoFragment()
            )
        }
        findViewById<View>(R.id.btnFotos).setOnClickListener {
            mostrarFragmento(
                FotosFragment()
            )
        }
        findViewById<View>(R.id.btnVideo).setOnClickListener {
            mostrarFragmento(
                VideoFragment()
            )
        }
        findViewById<View>(R.id.btnWeb).setOnClickListener {
            mostrarFragmento(
                WebFragment()
            )
        }
        findViewById<View>(R.id.btnBotones).setOnClickListener {
            mostrarFragmento(
                BotonesFragment()
            )
        }
    }

    private fun mostrarFragmento(fragmento: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.contenedorFragmentos, fragmento)
        transaction.commit()
    }
}