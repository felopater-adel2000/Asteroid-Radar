package com.udacity.asteroidradar.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.udacity.asteroidradar.PictureOfDay

@Entity(tableName = "picture_table")
data class PictureEntity(
    @PrimaryKey val url: String,
    val mediaType: String,
    val title: String,
    val copyright: String,
    val date: String,
    val service_version: String,
    val hdurl: String,
    val explanation: String
)
{
    fun toPictureOfDay(): PictureOfDay
    {
        return PictureOfDay(mediaType, title, url, copyright, date, service_version, hdurl, explanation)
    }
}