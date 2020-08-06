package com.sa.mymoviedb.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sa.mymoviedb.data.vos.MovieVO

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies ORDER BY popularity DESC")
    fun getAllPopularMovies() : LiveData<List<MovieVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<MovieVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movieVO: MovieVO)

    @Query("DELETE FROM movies")
    fun deleteAll()

    @Transaction
    fun deleteInsert(movies: List<MovieVO>){
        deleteAll()
        insertAll(movies)
    }
}