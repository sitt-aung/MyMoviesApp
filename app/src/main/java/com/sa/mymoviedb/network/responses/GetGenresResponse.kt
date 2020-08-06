package com.sa.mymoviedb.network.responses

import com.google.gson.annotations.SerializedName
import com.sa.mymoviedb.data.vos.GenreVO

data class GetGenresResponse(
    @SerializedName("genres") var genres: ArrayList<GenreVO> = arrayListOf()
)