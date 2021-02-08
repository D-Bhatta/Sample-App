package com.android.db.sampleapp.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.db.sampleapp.R
import com.android.db.sampleapp.data.api.ApiHelper
import com.android.db.sampleapp.data.api.RetrofitBuilder
import com.android.db.sampleapp.data.model.Picture
import com.android.db.sampleapp.ui.base.ViewModelFactory
import com.android.db.sampleapp.ui.main.viewmodel.MainViewModel
import com.android.db.sampleapp.utils.Status

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        // Setup Image Placeholder
    }

    private fun setupObservers() {
        var progress_loading = findViewById(R.id.progress_loading)
        viewModel.getPictures().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        progress_loading.visibility = View.GONE
                        resource.data?.let { pictures -> retrievePicture(pictures) }
                    }
                    Status.ERROR -> {
                        // Set image placeholder
                        progress_loading.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progress_loading.visibility = View.VISIBLE
                        // Set image view View.GONE
                    }
                }
            }
        })
    }

    private fun retrievePicture(pictures: List<Picture>) {
        // Set the ImageView with Picture.url
        /* RequestOptions options = new RequestOptions()
    .centerCrop()
    .placeholder(R.mipmap.ic_launcher_round)
    .error(R.mipmap.ic_launcher_round);



Glide.with(this).load(image_url).apply(options).into(imageView); */
    }
}