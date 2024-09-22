package com.example.appconfragmentos

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class WebFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_web, container, false)

        // Referencias a los elementos en el layout
        val webView = view.findViewById<WebView>(R.id.webView)
        val urlInput = view.findViewById<EditText>(R.id.urlInput)
        val cargar = view.findViewById<Button>(R.id.btnCargar)

        // Configuraciones de WebView
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false

        // Mantener las páginas dentro del WebView
        webView.webViewClient = WebViewClient()

        // Cargar la página por defecto
        val defaultUrl = "https://opensea.io/collection/boredapeyachtclub"
        webView.loadUrl(defaultUrl)

        // Acción al hacer clic en el botón "Cargar"
        cargar.setOnClickListener {
            val urlIngresada = urlInput.text.toString()
            if (urlIngresada.isNotBlank()) {
                webView.loadUrl(urlIngresada)
            }
        }

        return view
    }
}

