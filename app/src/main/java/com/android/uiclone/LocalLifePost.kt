package com.android.uiclone

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocalLifePost(
    var title :String,
    var contentPic : Int,
    var tags : List<String>,
    var content : String,
    var address : String,
    var time : String,
    var viewCoount : Int
) : Parcelable