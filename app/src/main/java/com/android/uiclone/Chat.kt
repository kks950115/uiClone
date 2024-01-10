package com.android.uiclone

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chat(
    var prifileImg : Int,
    var name : String,
    var address: String,
    var time: String,
    var content:String,
    var contentImg:Int
) : Parcelable

