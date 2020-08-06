package com.sa.mymoviedb.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sa.mymoviedb.data.vos.PersonVO

@Dao
interface PersonDao {

    @Query("SELECT * FROM persons")
    fun getAllActors() : LiveData<List<PersonVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(actors : List<PersonVO>)

    @Query("DELETE FROM persons")
    fun deleteAll()

    @Query("UPDATE persons SET isFavorite = :isFavorite WHERE id = :id")
    fun changeFavoriteState(id : Int, isFavorite : Boolean)

    @Transaction
    fun deleteAndInsert(actors: List<PersonVO>){
        deleteAll()
        insertAll(actors)
    }
}