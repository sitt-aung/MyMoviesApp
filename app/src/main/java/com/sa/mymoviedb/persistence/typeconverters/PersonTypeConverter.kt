package com.sa.mymoviedb.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sa.mymoviedb.data.vos.PersonVO

class PersonTypeConverter {

    @TypeConverter
    fun toString(personList : ArrayList<PersonVO>) : String{
        return Gson().toJson(personList)
    }

    @TypeConverter
    fun toPersonList(personTypeJsonString : String) : List<PersonVO>{
        val personListType = object : TypeToken<ArrayList<PersonVO>>() {}.type
        return Gson().fromJson(personTypeJsonString, personListType)
    }
}