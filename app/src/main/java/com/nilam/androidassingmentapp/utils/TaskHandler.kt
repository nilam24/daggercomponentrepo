package com.nilam.androidassingmentapp.utils

import android.content.Context
import android.view.View

interface TaskHandler {
    fun onEventClick(context: Context, view: View, position: Int, url: String)
}