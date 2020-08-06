package com.sa.mymoviedb.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sa.mymoviedb.data.vos.GenreVO

class GenreListTypeConverter {

    @TypeConverter
    fun toString(genreList: ArrayList<GenreVO>) : String {
        return Gson().toJson(genreList)
    }

    @TypeConverter
    fun toGenreList(genreListJsonString: String) : ArrayList<GenreVO>{
        val genreListType = object : TypeToken<ArrayList<GenreVO>>() {}.type
        return Gson().fromJson(genreListJsonString, genreListType)
    }
}