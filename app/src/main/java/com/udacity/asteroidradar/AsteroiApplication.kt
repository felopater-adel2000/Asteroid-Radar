package com.udacity.asteroidradar

import android.app.Application
import android.os.Build
import androidx.work.*
import com.udacity.asteroidradar.work.Worker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class AsteroidApplication : Application()
{
    val applicationScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        createWorker()
    }

    private fun createWorker() {
        applicationScope.launch {
            val constraint = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)
                .setRequiresBatteryNotLow(true)
                .setRequiresCharging(true)
                .apply {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        setRequiresDeviceIdle(true)
                    }
                }.build()

            //do worker 2 times in day
            val repeatedWorker = PeriodicWorkRequestBuilder<Worker>(12, TimeUnit.HOURS).setConstraints(constraint).build()

            WorkManager.getInstance().enqueueUniquePeriodicWork(Worker.workerNmae, ExistingPeriodicWorkPolicy.KEEP, repeatedWorker)
        }
    }
}