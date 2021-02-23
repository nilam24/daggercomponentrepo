package com.nilam.androidassingmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MediaData {
    @SerializedName("MediaItems")
    @Expose
    var mediaItems: List<MediaItem>? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param mediaItems
     */
    constructor(mediaItems: List<MediaItem>?) : super() {
        this.mediaItems = mediaItems
    }

}