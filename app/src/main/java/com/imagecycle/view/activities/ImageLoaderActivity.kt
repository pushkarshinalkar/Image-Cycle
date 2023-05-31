package com.imagecycle.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.imagecycle.R
import com.imagecycle.ViewModel.ImageViewModel
import com.imagecycle.databinding.ActivityImageLoaderBinding
import com.imagecycle.view.adapters.ImageListAdapter

class ImageLoaderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageLoaderBinding
    private lateinit var i_viewModel: ImageViewModel
    private lateinit var adapter: ImageListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageLoaderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            i_viewModel = ViewModelProvider(this@ImageLoaderActivity)[ImageViewModel::class.java]
            imagerec.layoutManager = LinearLayoutManager(this@ImageLoaderActivity)
            adapter = ImageListAdapter()
            imagerec.adapter = adapter

            i_viewModel.imagesLiveData.observe(this@ImageLoaderActivity, Observer { images ->
                adapter.updateData(images)
            })

            i_viewModel.fetchImages()
        }

    }
}