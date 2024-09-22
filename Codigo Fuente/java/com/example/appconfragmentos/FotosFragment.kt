package com.example.appconfragmentos

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment

class FotosFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fotos, container, false)

        for (i in 0..18) {

            val resId = resources.getIdentifier("imageView$i", "id", requireContext().packageName)

            val imageView = view.findViewById<ImageView>(resId)

            imageView?.let { setImageViewClickListener(it) }
        }
        return view
    }

    private fun setImageViewClickListener(imageView: ImageView) {
        imageView.setOnClickListener { v: View? ->
            val descripcion = imageView.contentDescription as String
            Toast.makeText(context, descripcion, Toast.LENGTH_SHORT).show()
        }
    }
}