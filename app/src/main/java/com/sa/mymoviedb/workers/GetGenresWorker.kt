package com.sa.mymoviedb.workers

import android.content.Context
import androidx.work.WorkerParameters

class GetGenresWorker(context: Context, workerParams: WorkerParameters)
    : BaseWorker(context, workerParams) {

    override fun doWork(): Result {
        var result = Result.failure()

        mMovieModel.getAllGenresAndSaveToDatabase(
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