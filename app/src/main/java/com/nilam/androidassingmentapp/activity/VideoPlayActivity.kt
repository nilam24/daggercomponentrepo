package com.nilam.androidassingmentapp.activity

import android.app.AlertDialog
import android.app.PictureInPictureParams
import android.content.DialogInterface
import android.content.Intent
import android.content.res.Configuration
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.nilam.androidassingmentapp.R
import com.nilam.androidassingmentapp.dagercomponets.DaggerCustomAlertDialogComponent
import com.nilam.androidassingmentapp.utils.CustomAlertDialog
import javax.inject.Inject

class VideoPlayActivity : AppCompatActivity() {
    lateinit var video_view: VideoView
    lateinit var progressBar: ProgressBar
    var videoUrl: Uri? = null
    lateinit var textLoad: TextView
    // use dagger to inject the class CustomAlertDialog
    @Inject lateinit var alertDialog: CustomAlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video_layout)
        DaggerCustomAlertDialogComponent.create().alertInject(this)
        video_view = findViewById(R.id.videoView)
        progressBar = findViewById(R.id.progressBar)
        textLoad = findViewById(R.id.browsing_video)
        textLoad.visibility = View.VISIBLE
        progressBar.visibility = View.VISIBLE

        //get uri from intent
        if (intent != null) {
            val intentData = intent
            if (intentData != null) {
                videoUrl = intentData.data
            }
        }
       // initialize mediaController
        val mediaController = MediaController(this)
        //anchor media controller to videoview
        mediaController.setAnchorView(video_view)
        // set media controller to videoview
        video_view.setMediaController(mediaController)
        //set video uri to video view
        video_view.setVideoURI(videoUrl)
        // set request focus to video view
        video_view.requestFocus()
        // video view with seek to position
        video_view.seekTo(0)

        //video view call prepareListener to start the video when prepare
        video_view.setOnPreparedListener {
            if (it != null) {
                progressBar.visibility = View.GONE
                textLoad.visibility = View.GONE
                video_view.start()

                it.setOnVideoSizeChangedListener { mediaPlayer, i, i2 ->
                    video_view.setMediaController(mediaController)
                    mediaController.setAnchorView(video_view)

                    // call setOnInfoListener on mediaPlayer to know
                    // when it is buffering to show the progressBar
                    mediaPlayer.setOnInfoListener { mediaPlayer, i, i2 ->
                        //when buffering start progressBar is visible
                        if (i == MediaPlayer.MEDIA_INFO_BUFFERING_START) {
                            progressBar.visibility = View.VISIBLE
                        }
                        //when buffering end progressBar is not visible
                        if (i == MediaPlayer.MEDIA_INFO_BUFFERING_END) {
                            progressBar.visibility = View.GONE
                        }
                        return@setOnInfoListener false

                    }
                    mediaPlayer.setOnBufferingUpdateListener { mediaPlayer, i ->

                    }

                }

            }
        }
        video_view.setOnCompletionListener {
            it.release()

        }
        video_view.setOnErrorListener { mediaPlayer, i, i2 ->

            textLoad.visibility = View.GONE
            progressBar.visibility = View.GONE
            mediaPlayer.release()
            //custom alert dialog injected to call previous activity on dialog dismissed
            alertDialog.setAlertMessage(this)

            return@setOnErrorListener true

        }

    }

    //when user press home button the video play in PictureInPicture mode
    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        setParams()

    }

    //build the params for picture in picture mode and call the method enterPictureInPictureMode()
    fun setParams() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val params: PictureInPictureParams = PictureInPictureParams.Builder().build()
            enterPictureInPictureMode(params)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        backPress()

    }
  //on back press intent to the previous activity
    private fun backPress() {
        val intentBack = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intentBack)
    }

    //when Picture in picture mode is changed by user to full screen or vice versa
    override fun onPictureInPictureModeChanged(
        isInPictureInPictureMode: Boolean,
        newConfig: Configuration?
    ) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
        if (isInPictureInPictureMode) {
            setParams()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()

    }

    override fun onDestroy() {
        super.onDestroy()
        if (video_view.isPlaying) {
           video_view.stopPlayback()
        }
        video_view.visibility=View.GONE
        finish()
    }
}