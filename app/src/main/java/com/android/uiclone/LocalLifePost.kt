package com.android.uiclone

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocalLifePost(
    var name : String,
    var title :String,
    var contentPic : Int,
    var tags : List<String>,
    var content : String,
    var address : String,
    var time : String,
    var viewCoount : Int
) : Parcelable


@Parcelize
data class LocalDetailComment(
    var name : String,
    var address : String,
    var content : String,
    var personPic : Int

) : Parcelable