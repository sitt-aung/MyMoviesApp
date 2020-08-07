package com.sa.mymoviedb.mvp.presenters.impls

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sa.mymoviedb.data.models.MovieModel
import com.sa.mymoviedb.data.models.impls.MockMovieModelImpl
import com.sa.mymoviedb.data.models.impls.MovieModelImpl
import com.sa.mymoviedb.dummy.getDummyMovies
import com.sa.mymoviedb.mvp.presenters.GenrePresenterImpl
import com.sa.mymoviedb.mvp.views.GenreListView
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import io.mockk.MockKAnnotations
import org.junit.Test
import org.mockito.Mockito.*

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class GenrePresenterImplTest {

    private lateinit var mPresenter: GenrePresenterImpl

    @RelaxedMockK
    private lateinit var mView: GenreListView

    private lateinit var mMovieModel: MovieModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)

        MovieModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mMovieModel = MockMovieModelImpl

        mPresenter = GenrePresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMovieModel = this.mMovieModel
    }

}