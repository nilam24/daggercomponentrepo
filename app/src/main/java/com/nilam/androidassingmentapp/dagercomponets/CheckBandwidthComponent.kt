package com.nilam.androidassingmentapp.dagercomponets

import android.app.Activity
import com.nilam.androidassingmentapp.activity.MainActivity
import dagger.Component

@Component
interface CheckBandwidthComponent {
     fun injectCheckBandwidth(activity: MainActivity)

}