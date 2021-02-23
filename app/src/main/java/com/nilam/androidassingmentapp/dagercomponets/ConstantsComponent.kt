package com.nilam.androidassingmentapp.dagercomponets

import android.app.Activity
import com.nilam.androidassingmentapp.viewmodel.VideoViewModel
import dagger.Component

//dependency injection
@Component
interface ConstantsComponent {
    fun inject(viewModel: VideoViewModel)
}