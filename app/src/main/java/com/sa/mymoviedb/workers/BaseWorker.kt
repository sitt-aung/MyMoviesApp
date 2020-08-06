package com.sa.mymoviedb.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.sa.mymoviedb.data.models.MovieModel
import com.sa.mymoviedb.data.models.impls.MovieModelImpl

abstract class BaseWorker(context: Context, workerParams: WorkerParameters)
    : Worker(context, workerParams) {

    val mMovieModel: MovieModel = MovieModelImpl
}