package com.udacity.asteroidradar.repository

import android.util.Log
import androidx.lifecycle.Transformations
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.Constants
import com.udacity.asteroidradar.Mapper
import com.udacity.asteroidradar.PictureOfDay
import com.udacity.asteroidradar.api.parseAsteroidsJsonResult
import com.udacity.asteroidradar.database.AsteroidDatabase
import com.udacity.asteroidradar.network.APIServicesAsteroid
import com.udacity.asteroidradar.network.APIServicesImage
import org.json.JSONObject
import java.text.SimpleDateFormat

class Repository(val database: AsteroidDatabase)
{
    val asteroids = Transformations.map(database.asteroidDao.getAllAsteroid()){
        Mapper.toListAsteroid(it)
    }

    val pictureOfDay = Transformations.map(database.asteroidDao.getPictureOfDay()) {
        it
    }

    suspend fun refreshData()
    {
        try {
            val startDay = SimpleDateFormat(Constants.API_QUERY_DATE_FORMAT).format(System.currentTimeMillis())
            val asteroidsString = APIServicesAsteroid.apiAsteroid.getAsteroid(startDay, Constants.API_KEY)
            val asteroids = parseAsteroidsJsonResult(JSONObject(asteroidsString))
            database.asteroidDao.clearAllAsteroid()

            val pictureOfDay = APIServicesImage.apiImage.getImage(Constants.API_KEY)
            database.asteroidDao.insertPicture(pictureOfDay.toPictureEntity())

            for(asteroid in asteroids)
            {
                database.asteroidDao.insertAsteroid(asteroid.toAsteroidEntity())
            }

        }catch(e: java.lang.Exception)
        {
            Log.i("Felo", "Repo Error")
            Log.i("Felo", e.message!!)
        }
    }


}