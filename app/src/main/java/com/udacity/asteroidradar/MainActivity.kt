package com.udacity.asteroidradar

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.udacity.asteroidradar.api.parseAsteroidsJsonResult
import com.udacity.asteroidradar.database.AsteroidDatabase
import com.udacity.asteroidradar.network.APIServicesAsteroid
import com.udacity.asteroidradar.network.APIServicesImage
import com.udacity.asteroidradar.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject

import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //fast test API Asteroid
//        GlobalScope.launch {
//            val startDay = SimpleDateFormat(Constants.API_QUERY_DATE_FORMAT).format(System.currentTimeMillis())
//            Log.i("Felo", startDay)
//            val response = APIServicesAsteroid.apiAsteroid.getAsteroid(startDay, Constants.API_KEY)
//
//            val jsonResponse = JSONObject(response)
//            val list = parseAsteroidsJsonResult(jsonResponse)
//            Log.i("Felo", list.size.toString())
//            Log.i("Felo", list[0].id.toString())
//        }

        //fast test API Image
//        GlobalScope.launch {
//            val pictureOfDay = APIServicesImage.apiImage.getImage(Constants.API_KEY)
//
//            Log.i("Felo", pictureOfDay.title)
//            Log.i("Felo", pictureOfDay.copyright)
//            Log.i("Felo", pictureOfDay.mediaType)
//        }

        //fast test of repository
//        GlobalScope.launch {
//            val database = AsteroidDatabase.getInstance(applicationContext)
//            val repo = Repository(database)
//            withContext(Dispatchers.Main){
//                repo.asteroids.observe(this@MainActivity, Observer {
////                    if(it.size > 0)
////                    {
////                        Log.i("Felo", it[0].id.toString())
////                        Log.i("Felo", it[0].codename)
////                    }
//                })
//                repo.pictureOfDay.observe(this@MainActivity, Observer {
//                    if(it != null)
//                    {
//                        Log.i("Felo", it.url)
//                    }
//                })
//            }
//            repo.refreshData()
//        }
    }
}

/**
 * APIServices Key:  z18SCojzscD708T80frXZR6exOb05QzFHNdm096T
 *
 * APIServices Link: https://api.nasa.gov/planetary/apod?api_key=z18SCojzscD708T80frXZR6exOb05QzFHNdm096T
 *
 * Exmaple Query: https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=DEMO_KEY
 *
 * 3 Query Parameter:
 *  . API_KEY
 *  . START_DATE
 *  . END_DATE
 *
 *  data you need:
 *  id": "2465633"
 *  date:
 *  "absolute_magnitude_h": 20.36,
 *  estimated_diameter": {
"kilometers": {
"estimated_diameter_min": 0.2251930467,
"estimated_diameter_max": 0.5035469604
 *  "is_potentially_hazardous_asteroid": true,
 *  close_approach_data -> relative_velocity -> kilometers_per_second
 *  close_approach_data -> miss_distance -> astronomical
 *
 *  Example of start Date for test: 2022-10-30
 *
 **/
