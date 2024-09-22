package com.example.appconfragmentos

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment

class VideoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_video, container, false)

        val videoView1 = view.findViewById<VideoView>(R.id.videoView)
        val mediaController1 = MediaController(context)
        mediaController1.setAnchorView(videoView1)
        val videoUri1 = Uri.parse("android.resource://" + requireActivity().packageName + "/" + R.raw.ba_vid1)
        videoView1.setMediaController(mediaController1)
        videoView1.setVideoURI(videoUri1)
        videoView1.requestFocus()
        videoView1.start()

        val videoView2 = view.findViewById<VideoView>(R.id.videoView2)
        val mediaController2 = MediaController(context)
        mediaController2.setAnchorView(videoView2)
        val videoUri2 = Uri.parse("android.resource://" + requireActivity().packageName + "/" + R.raw.ba_vid2)
        videoView2.setMediaController(mediaController2)
        videoView2.setVideoURI(videoUri2)
        videoView2.requestFocus()
        videoView2.start()

        val videoView3 = view.findViewById<VideoView>(R.id.videoView3)
        val mediaController3 = MediaController(context)
        mediaController3.setAnchorView(videoView2)
        val videoUri3 = Uri.parse("android.resource://" + requireActivity().packageName + "/" + R.raw.ba_vid3)
        videoView3.setMediaController(mediaController3)
        videoView3.setVideoURI(videoUri3)
        videoView3.requestFocus()
        videoView3.start()

        return view
    }
}
