package com.sa.mymoviedb.data.models

import android.content.Context
import com.sa.mymoviedb.network.MovieApi
import com.sa.mymoviedb.persistence.db.MoviesDB
import com.sa.mymoviedb.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    protected var mMovieApi: MovieApi
    protected lateinit var mMoviesDB: MoviesDB

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mMovieApi = retrofit.create(MovieApi::class.java)
    }

    fun initDatabase(context: Context) {
        mMoviesDB = MoviesDB.getDBInstance(context)
    }
}