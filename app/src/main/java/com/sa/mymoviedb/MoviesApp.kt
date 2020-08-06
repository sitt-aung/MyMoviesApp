package com.sa.mymoviedb

import android.app.Application
import androidx.work.*
import com.sa.mymoviedb.data.models.impls.MovieModelImpl
import com.sa.mymoviedb.workers.GetActorsWorker
import com.sa.mymoviedb.workers.GetGenresWorker
import com.sa.mymoviedb.workers.GetPopularMoviesWorker

class MoviesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        MovieModelImpl.initDatabase(applicationContext)

        getPopularMoviesOneTime()
        getGenresOneTime()
        getActorsWorker()
    }

    private fun getPopularMoviesOneTime() {
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(GetPopularMoviesWorker::class.java)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }

    private fun getGenresOneTime() {
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(GetGenresWorker::class.java)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }

    private fun getActorsWorker() {
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(GetActorsWorker::class.java)
            .build()

        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }
}