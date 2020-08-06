package com.sa.mymoviedb.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sa.mymoviedb.data.vos.GenreVO
import com.sa.mymoviedb.data.vos.MovieVO
import com.sa.mymoviedb.data.vos.PersonVO
import com.sa.mymoviedb.persistence.daos.GenreDao
import com.sa.mymoviedb.persistence.daos.MovieDao
import com.sa.mymoviedb.persistence.daos.PersonDao

@Database(entities = [
    MovieVO::class,
    GenreVO::class,
    PersonVO::class
], version = 1, exportSchema = false)
abstract class MoviesDB : RoomDatabase() {

    companion object {
        val DB_NAME = "PADCX_MOVIES.DB"
        var dbInstance: MoviesDB? = null

        fun getDBInstance(context: Context): MoviesDB {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, MoviesDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            var i = dbInstance
            return i!!
        }
    }

    abstract fun movieDao(): MovieDao
    abstract fun personDao(): PersonDao
    abstract fun genreDao(): GenreDao
}