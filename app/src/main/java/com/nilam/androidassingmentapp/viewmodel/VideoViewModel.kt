package com.nilam.androidassingmentapp.viewmodel

import androidx.lifecycle.ViewModel
import com.nilam.androidassingmentapp.dagercomponets.DaggerConstantsComponent
import com.nilam.androidassingmentapp.model.Constants
import com.nilam.androidassingmentapp.model.MediaItem
import javax.inject.Inject

//video view model injected through constructor
class VideoViewModel @Inject constructor() : ViewModel(){

    //Constants class inject
    @Inject lateinit var constants: Constants
    var listMedia:List<MediaItem> = ArrayList()
    fun getListMediaData() : List<MediaItem>{
        //dagger component create to inialize the constants class
        DaggerConstantsComponent.create().inject(this)
        //get media list data from constants class
        listMedia=constants.setMediaDataList()
        return listMedia
    }

}