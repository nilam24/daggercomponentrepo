package com.nilam.androidassingmentapp.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nilam.androidassingmentapp.R
import com.nilam.androidassingmentapp.adapter.MediaAdapter
import com.nilam.androidassingmentapp.model.MediaItem
import com.nilam.androidassingmentapp.utils.TaskHandler
import com.nilam.androidassingmentapp.viewmodel.VideoViewModel

class MainActivity : AppCompatActivity(),
    TaskHandler {

    lateinit var recyclerViewMediaItem: RecyclerView
    lateinit var emptyTextView: TextView
    lateinit var mediaAdapter: MediaAdapter
    lateinit var videoViewModel: VideoViewModel
    var mediaItemList: List<MediaItem> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // instanciate view model class
        videoViewModel = ViewModelProvider.AndroidViewModelFactory(application).create(
            VideoViewModel::class.java
        )

        recyclerViewMediaItem = findViewById(R.id.recycler_media)
        emptyTextView = findViewById(R.id.tvEmpty)
        mediaAdapter = MediaAdapter()
        val mediaLayoutManager: LinearLayoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        //set list for media data
        mediaItemList = getMediaList()
        if (mediaItemList.isEmpty()) {
            emptyTextView.visibility = View.VISIBLE
            recyclerViewMediaItem.visibility = View.GONE
        }
        // set adapter with mediaItem list
        mediaAdapter.setData(mediaItemList)
        recyclerViewMediaItem.layoutManager = mediaLayoutManager
        recyclerViewMediaItem.itemAnimator = DefaultItemAnimator()
        recyclerViewMediaItem.adapter = mediaAdapter
        mediaAdapter.notifyDataSetChanged()
    }

    // event click perform on item- image click
    override fun onEventClick(context: Context, view: View, position: Int, url: String) {
        startVideoMode(context, url)

    }

    fun getMediaList(): List<MediaItem> {
        mediaItemList =
            videoViewModel.getListMediaData()
        return mediaItemList
    }

    // start video activity
    fun startVideoMode(context: Context, url: String) {
        val intent = Intent(
            context,
            VideoPlayActivity::class.java
        )
   //set uri data to intent
        intent.setData(Uri.parse(url))
        context.startActivity(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}