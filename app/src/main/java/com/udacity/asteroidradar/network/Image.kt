package com.udacity.asteroidradar.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.Constants
import com.udacity.asteroidradar.PictureOfDay
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface APIImage
{
    @GET(Constants.END_POINT_OF_IMAGE)
    suspend fun getImage(@Query("api_key") apiKey: String): PictureOfDay
}

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofitImage = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(okHttpClint)
    .baseUrl(Constants.BASE_URL)
    .build()

object APIServicesImage
{
    val apiImage: APIImage by lazy {
        retrofitImage.create(APIImage::class.java)
    }
}