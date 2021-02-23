package com.nilam.androidassingmentapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nilam.androidassingmentapp.R
import com.nilam.androidassingmentapp.activity.MainActivity
import com.nilam.androidassingmentapp.model.MediaItem
import com.nilam.androidassingmentapp.utils.TaskHandler
import com.squareup.picasso.Picasso

class MediaAdapter : RecyclerView.Adapter<MediaAdapter.MediaViewHolder>() {

    var taskHandler: TaskHandler =
        MainActivity()
    var mediaItemList:List<MediaItem> = ArrayList()
    fun setData(mediaItemList:List<MediaItem>){
        this.mediaItemList=mediaItemList

    }

    class MediaViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var imageView: ImageView = itemView.findViewById(R.id.ivMedia)
        var textTitle: TextView = itemView.findViewById(R.id.tvTitle)
        var textDuration:TextView = itemView.findViewById(R.id.tvDuration)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val root=LayoutInflater.from(parent.context).inflate(R.layout.media_list_item,parent,false)
        return MediaViewHolder(
            root
        )
    }

    override fun getItemCount(): Int {
        if(mediaItemList.isEmpty()) return 0
        return mediaItemList.size
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        val mediaItem=mediaItemList.get(position)
        holder.textTitle.text = mediaItem.title
        holder.textDuration.text = "Duration"
        Picasso.get().load(mediaItem.image).placeholder(R.drawable.ic_launcher_background).error(
            R.drawable.ic_launcher_foreground
        ).into(holder.imageView)
        holder.imageView.setOnClickListener {
            mediaItem.url?.let { it1 -> taskHandler.onEventClick(holder.textDuration.context,holder.textDuration,position, it1) }
        }
    }
}