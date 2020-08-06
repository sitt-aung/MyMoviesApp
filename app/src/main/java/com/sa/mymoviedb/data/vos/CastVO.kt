package com.sa.mymoviedb.data.vos

import com.google.gson.annotations.SerializedName

data class CastVO(
    @SerializedName("cast_id") var castId: Int = 0,
    @SerializedName("character") var character: String = "",
    @SerializedName("credit_id") var creditId: String = "",
    @SerializedName("gender") var gender: Int = 0,
    @SerializedName("id") var id: Int = 0,
    @SerializedName("name") var name: String = "",
    @SerializedName("order") var order: Int = 0,
    @SerializedName("profile_path") var profilePath: String = ""
)