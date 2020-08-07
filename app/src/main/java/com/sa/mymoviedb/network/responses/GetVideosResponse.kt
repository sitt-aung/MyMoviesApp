package com.sa.mymoviedb.network.responses

import com.google.gson.annotations.SerializedName
import com.sa.mymoviedb.data.vos.VideoVO

data class GetVideosResponse(
    @SerializedName("results") val results: List<VideoVO> = listOf()
)