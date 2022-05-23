package com.penatabahasa.myselfapps.ui.main.fragments

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.penatabahasa.myselfapps.R
import com.penatabahasa.myselfapps.adapter.FavoriteMusicAdapter
import com.penatabahasa.myselfapps.databinding.FragmentMediaBinding
import com.penatabahasa.myselfapps.helper.ViewModelFactory
import com.penatabahasa.myselfapps.viewmodel.FavoriteMusicViewModel

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class MediaFragment : Fragment() {
    private var _binding: FragmentMediaBinding? = null
    private val binding get() = _binding!!
    private var mediaController: MediaController? = null
    private lateinit var favMusicAdapter: FavoriteMusicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMediaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showFavoriteMusicList()
        showFavoriteVideo()
    }

    override fun onResume() {
        super.onResume()
        showFavoriteMusicList()
    }

    private fun showFavoriteVideo() {
        binding.apply {
            if (mediaController == null) {
                mediaController = MediaController(activity)
                mediaController!!.setAnchorView(this.videoView)
            }

            videoView.setMediaController(mediaController)
            videoView.setVideoURI(Uri.parse("android.resource://com.penatabahasa.myselfapps/" + R.raw.waterfall_video))
            videoView.requestFocus()
            videoView.start()

            videoView.setOnErrorListener { _, _, _ ->
                Toast.makeText(activity, "Error Occurred", Toast.LENGTH_LONG).show()
                false
            }
        }
    }

    private fun showFavoriteMusicList() {
        binding.apply {
            val favMusicViewModel =
                obtainFavoriteMusicViewModel(requireActivity() as AppCompatActivity)
            favMusicViewModel.getAllFavoriteMusics().observe(viewLifecycleOwner) { favMusic ->
                if (favMusic != null) {
                    favMusicAdapter.setListFavoriteMusic(favMusic)
                    Log.d("Data", favMusic.toString())
                }
            }

            rvFavoriteMusic.layoutManager = LinearLayoutManager(activity)
            favMusicAdapter = FavoriteMusicAdapter()
            rvFavoriteMusic.adapter = favMusicAdapter
        }
    }

    private fun obtainFavoriteMusicViewModel(activity: AppCompatActivity): FavoriteMusicViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[FavoriteMusicViewModel::class.java]
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}