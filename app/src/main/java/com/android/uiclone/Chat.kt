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
@Parcelize
data class ChatDetail(
    val personName : String,
    var temper : String,
    var tradeStatus : String,
    val productName : String,
    var productPrice : String,
    var productPic : Int
) : Parcelable

@Parcelize
data class ChatLog(
    var content : String,
    val time : String,
    val viewType : Int,
    val img : Int
) : Parcelable