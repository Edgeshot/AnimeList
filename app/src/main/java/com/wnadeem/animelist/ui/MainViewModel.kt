package com.wnadeem.animelist.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wnadeem.animelist.Anime
import com.wnadeem.animelist.AnimeDatabase
import com.wnadeem.animelist.AnimeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val allAnime: LiveData<List<Anime>>
    val repository: AnimeRepository

    init{
        val dao = AnimeDatabase.getDatabase(application).AnimeDao()
        repository = AnimeRepository(dao)
        allAnime = repository.allAnime
    }

    fun deleteAnime(anime: Anime) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(anime)
    }
    fun updateAnime(anime: Anime) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(anime)
    }
    fun addAnime(anime: Anime) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(anime)
    }

}