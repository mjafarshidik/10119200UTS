package com.penatabahasa.myselfapps.ui.main.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.penatabahasa.myselfapps.adapter.GalleryAdapter
import com.penatabahasa.myselfapps.databinding.FragmentGalleryBinding
import com.penatabahasa.myselfapps.helper.ViewModelFactory
import com.penatabahasa.myselfapps.viewmodel.GalleryViewModel

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class GalleryFragment : Fragment() {
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private lateinit var galleryAdapter: GalleryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showGalleryList()
    }

    override fun onResume() {
        super.onResume()
        showGalleryList()
    }

    private fun showGalleryList() {
        binding.apply {
            val galleryViewModel = obtainGalleryViewModel(requireActivity() as AppCompatActivity)
            galleryViewModel.getAllGalleries().observe(viewLifecycleOwner) { gallery ->
                if (gallery != null) {
                    galleryAdapter.setListGallery(gallery)
                    Log.d("Data", gallery.toString())
                }
            }

            rvGallery.layoutManager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
            galleryAdapter = GalleryAdapter()
            rvGallery.adapter = galleryAdapter
        }
    }

    private fun obtainGalleryViewModel(activity: AppCompatActivity): GalleryViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[GalleryViewModel::class.java]
    }
}