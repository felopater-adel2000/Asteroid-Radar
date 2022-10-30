package com.udacity.asteroidradar.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.asteroidradar.database.AsteroidDatabase
import com.udacity.asteroidradar.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(val context: Context) : ViewModel()
{
    private val database = AsteroidDatabase.getInstance(context)
    private val repo = Repository(database)

    init {
        viewModelScope.launch {
            repo.refreshData()
        }
    }


}