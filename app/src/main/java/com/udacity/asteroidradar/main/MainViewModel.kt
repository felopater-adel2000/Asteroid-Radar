package com.udacity.asteroidradar.main

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.PictureOfDay
import com.udacity.asteroidradar.database.AsteroidDatabase
import com.udacity.asteroidradar.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(val context: Context) : ViewModel()
{
    private val database = AsteroidDatabase.getInstance(context)
    private val repo = Repository(database)

    val pictureOfDay = Transformations.map(database.asteroidDao.getPictureOfDay()){
        it.toPictureOfDay()
    }


    private val _filterationAsteroid = MutableLiveData<List<Asteroid>>()
    val filterationAsteroid: LiveData<List<Asteroid>>
        get() = _filterationAsteroid

    private val _navigationToAsteroidDetails = MutableLiveData<Asteroid>()
    val navigationToAsteroidDetails: LiveData<Asteroid>
        get() = _navigationToAsteroidDetails
    init {
        viewModelScope.launch {
            repo.refreshData()
        }

    }


}