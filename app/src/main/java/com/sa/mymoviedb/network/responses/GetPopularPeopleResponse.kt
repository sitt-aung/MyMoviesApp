package com.sa.mymoviedb.network.responses

import com.google.gson.annotations.SerializedName
import com.sa.mymoviedb.data.vos.PersonVO

data class GetPopularPeopleResponse(
    @SerializedName("results") var results: List<PersonVO> = listOf()
)