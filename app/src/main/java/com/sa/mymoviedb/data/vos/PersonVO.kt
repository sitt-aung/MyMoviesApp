package com.sa.mymoviedb.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

@Entity(tableName = "persons")
@TypeConverters()
data class PersonVO (
    @PrimaryKey
    @SerializedName("id") var id : Int = 0,
    @SerializedName("name") var name: String = "",
    @SerializedName("profile_path") var profilePath: String = "",
    var isFavorite: Boolean
)