package com.sa.mymoviedb.data.vos

import com.google.gson.annotations.SerializedName

data class VideoVO(
    @SerializedName("id") val id: String = "",
    @SerializedName("key") val key: String = "",
    @SerializedName("site") val site: String = "",
    @SerializedName("size") val size: Int = 0,
    @SerializedName("type") val type: String = ""
)