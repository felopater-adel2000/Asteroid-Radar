package com.udacity.asteroidradar

import com.udacity.asteroidradar.database.AsteroidEntity
import java.util.LinkedList

object Mapper
{
    fun toListAsteroid(asteroidEntity: List<AsteroidEntity>): List<Asteroid>
    {
        val result = LinkedList<Asteroid>()

        for(est in asteroidEntity){ result.add(est.toAsteroid())}
        return result
    }

    fun toListAsteroidEntity(asteroids: List<Asteroid>): List<AsteroidEntity>
    {
        val result = LinkedList<AsteroidEntity>()
        for(est in asteroids){result.add(est.toAsteroidEntity())}
        return result
    }
}