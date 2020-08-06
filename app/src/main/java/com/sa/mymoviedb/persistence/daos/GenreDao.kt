package com.sa.mymoviedb.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sa.mymoviedb.data.vos.GenreVO

@Dao
interface GenreDao {

    @Query("SELECT * FROM genres")
    fun getAllGenres() : LiveData<List<GenreVO>>

    @Query("DELETE FROM genres")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(genres: List<GenreVO>)

    @Transaction
    fun deleteAndInsert(genres: List<GenreVO>){
        deleteAll()
        insertAll(genres)
    }
}