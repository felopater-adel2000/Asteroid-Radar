package com.udacity.asteroidradar.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.asteroidradar.PictureOfDay

@Dao
interface AsteroidDao
{
    @Query("select * from asteroid_table order by closeApproachDate")
    suspend fun getAllAsteroid(): List<AsteroidEntity>

    @Query("select * from asteroid_table where closeApproachDate =:date")
    suspend fun getTodayAsteroid(date: String): List<AsteroidEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAsteroid(asteroids: List<AsteroidEntity>)

    @Query("delete from asteroid_table")
    suspend fun clearAllAsteroid()

    @Query("select * from picture_table order by url desc limit 1")
    fun getPictureOfDay(): LiveData<PictureEntity>

    @Query("delete from picture_table")
    suspend fun clearPictureOfDay()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPicture(pic: PictureEntity)
}