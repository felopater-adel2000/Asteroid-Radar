package com.udacity.asteroidradar

import com.squareup.moshi.Json
import com.udacity.asteroidradar.database.PictureEntity

data class PictureOfDay(
    @Json(name = "media_type") val mediaType: String,
    val title: String,
    val url: String,
    val copyright: String,
    val date: String,
    val service_version: String,
    val hdurl: String,
    val explanation: String
)
{
    fun toPictureEntity(): PictureEntity
    {
        return PictureEntity(url, mediaType, title, copyright, date, service_version, hdurl, explanation)
    }
}