package com.nilam.androidassingmentapp.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import javax.inject.Inject

//custom alert dialog is created to call the onBackPressed()
//the class is inject through dagger2
class CustomAlertDialog @Inject constructor(){

        fun setAlertMessage(activity: Activity,message:String){
            val alert = AlertDialog.Builder(activity).create()
            alert.setMessage(message)
            alert.setButton(
                DialogInterface.BUTTON_POSITIVE,
                "ok",
                object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, p1: Int) {
                        dialog?.dismiss()
                        activity.onBackPressed()
                    }
                })
            alert.show()

        }

}