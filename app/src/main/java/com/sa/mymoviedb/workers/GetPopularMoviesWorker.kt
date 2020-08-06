package com.sa.mymoviedb.workers

import android.content.Context
import androidx.work.WorkerParameters

class GetPopularMoviesWorker(context: Context, workerParams: WorkerParameters)
    : BaseWorker(context, workerParams) {

    override fun doWork(): Result {
        var result = Result.failure()

        mMovieModel.getAllMoviesAndSaveToDatabase(
            onSuccess = {
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )

        return result
    }
}