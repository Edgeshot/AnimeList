package com.wnadeem.animelist

import androidx.lifecycle.LiveData

class AnimeRepository (private val animeDao: AnimeDao) {


    val allAnime: LiveData<List<Anime>> = animeDao.getAllAnime()


    fun insert(anime: Anime) {

            animeDao.insert(anime)

    }

    fun delete(anime: Anime) {

            animeDao.delete(anime)

    }

    suspend fun update(anime: Anime){
        animeDao.update(anime)
    }



}