package com.sa.mymoviedb.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sa.mymoviedb.data.vos.MovieVO

class MovieTypeConverter {
    @TypeConverter
    fun toString(list : List<MovieVO>) : String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(movieStr : String) : List<MovieVO>{
        val movieListType = object : TypeToken<ArrayList<MovieVO>>() {}.type
        return Gson().fromJson(movieStr, movieListType)
    }
}