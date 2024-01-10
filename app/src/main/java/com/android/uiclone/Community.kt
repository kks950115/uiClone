package com.android.uiclone

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Community(
    var name : String,
    var img : Int
) : Parcelable

