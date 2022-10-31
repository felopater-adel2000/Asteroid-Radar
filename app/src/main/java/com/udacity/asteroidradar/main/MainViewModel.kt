package com.udacity.asteroidradar.main

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.Constants
import com.udacity.asteroidradar.PictureOfDay
import com.udacity.asteroidradar.database.AsteroidDatabase
import com.udacity.asteroidradar.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(val context: Context) : ViewModel()
{
    private val database = AsteroidDatabase.getInstance(context)
    private val repo = Repository(database)

    val pictureOfDay = repo.pictureOfDay

     private val _filterationAsteroid = MutableLiveData<List<Asteroid>>()
    val filterationAsteroid: LiveData<List<Asteroid>>
        get() = _filterationAsteroid


    private val _navigationToAsteroidDetails = MutableLiveData<Asteroid>()
    val navigationToAsteroidDetails: LiveData<Asteroid>
        get() = _navigationToAsteroidDetails

    init {
        viewModelScope.launch {
            repo.refreshData()
            _filterationAsteroid.value = repo.getAllAsteroid()
        }
    }

    fun onNavigationToDetails(asteroid: Asteroid)
    {
        _navigationToAsteroidDetails.value = asteroid
    }
    fun onCompleteNavigation()
    {
        _navigationToAsteroidDetails.value = null
    }

    fun filterAsteroidsData(filter: String)
    {
        viewModelScope.launch {
            when(filter)
            {
                Constants.WEEK_ASTEROID -> _filterationAsteroid.value = repo.getAllAsteroid()
                Constants.TODAY_ASTEROID -> _filterationAsteroid.value = repo.getTodayAsteroid()
                else -> _filterationAsteroid.value = repo.getAllAsteroid()
            }
        }
    }


}