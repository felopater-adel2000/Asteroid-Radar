package com.udacity.asteroidradar.network

import com.udacity.asteroidradar.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface APIServices
{
    @GET(Constants.END_POINT_OF_ASTEROID)
    suspend fun getAsteroid(@Query("start_date") startDate: String, @Query("api_key") apiKey: String): String
}
// increase TimeOut to avoiding crash
val okHttpClint = OkHttpClient.Builder()
    .connectTimeout(30, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS)
    .writeTimeout(30, TimeUnit.SECONDS)
    .build()

private val retrofitServices = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(Constants.BASE_URL)
    .client(okHttpClint)
    .build()

object APIServicesAsteroid
{
    val apiAsteroid: APIServices by lazy {
        retrofitServices.create(APIServices::class.java)
    }
}