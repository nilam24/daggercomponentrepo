package com.nilam.androidassingmentapp.dagercomponets

import com.nilam.androidassingmentapp.activity.VideoPlayActivity
import dagger.Component

//dependency injection
@Component
interface CustomAlertDialogComponent {
    fun alertInject(activity: VideoPlayActivity)
}