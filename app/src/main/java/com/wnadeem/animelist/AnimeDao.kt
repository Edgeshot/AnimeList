package com.wnadeem.animelist

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface  AnimeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(anime: Anime)

    @Query("DELETE FROM animeTable")
    fun deleteAll()

    @Delete
    fun delete(anime: Anime)

    @Update
    fun update(anime: Anime)

    @Query("SELECT * FROM animeTable LIMIT 1")
    fun getAnyAnime(): Array<Anime>

    @Query("SELECT * FROM  animeTable ORDER BY id DESC")
    fun getAllAnime(): LiveData<List<Anime>>
}