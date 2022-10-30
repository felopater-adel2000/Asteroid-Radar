package com.udacity.asteroidradar.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.udacity.asteroidradar.database.AsteroidDatabase
import com.udacity.asteroidradar.repository.Repository

class Worker(val context: Context, val parameters: WorkerParameters) : CoroutineWorker(context, parameters)
{
    override suspend fun doWork(): Result {
        val database = AsteroidDatabase.getInstance(context)
        val repo = Repository(database)

        return try{
            repo.refreshData()
            Result.success()
        }catch(e: java.lang.Exception)
        {
            Result.failure()
        }
    }

    companion object{
        val workerNmae = "Worker"
    }
}