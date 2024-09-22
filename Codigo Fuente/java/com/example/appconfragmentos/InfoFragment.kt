package com.example.appconfragmentos

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class InfoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_perfil, container, false)

        // Cargar Gif
        val ba_gif = view.findViewById<ImageView>(R.id.ba_gif)
        Glide.with(this).load(R.drawable.ba).into(ba_gif)
        return view
    }
}