package com.nilam.androidassingmentapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MediaItem {
    @SerializedName("Title")
    @Expose
    var title: String? = null

    @SerializedName("Image")
    @Expose
    var image: String? = null

    @SerializedName("Url")
    @Expose
    var url: String? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param image
     * @param title
     * @param url
     */
    constructor(title: String?, image: String?, url: String?) : super() {
        this.title = title
        this.image = image
        this.url = url
    }
}