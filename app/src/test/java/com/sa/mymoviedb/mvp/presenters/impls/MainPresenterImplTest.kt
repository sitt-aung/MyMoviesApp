package com.sa.mymoviedb.mvp.presenters.impls

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sa.mymoviedb.data.models.MovieModel
import com.sa.mymoviedb.data.models.impls.MockMovieModelImpl
import com.sa.mymoviedb.data.models.impls.MovieModelImpl
import com.sa.mymoviedb.dummy.getDummyActors
import com.sa.mymoviedb.dummy.getDummyGenres
import com.sa.mymoviedb.dummy.getDummyMovies
import com.sa.mymoviedb.mvp.presenters.MainPresenterImpl
import com.sa.mymoviedb.mvp.views.MainView
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import io.mockk.MockKAnnotations
import io.mockk.verify
import org.junit.Test
import org.mockito.Mockito.*

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {

    private lateinit var mPresenter: MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView: MainView

    private lateinit var mMovieModel: MovieModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)

        MovieModelImpl.initDatabase(ApplicationProvider.getApplicationContext())
        mMovieModel = MockMovieModelImpl

        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mMovieModel = this.mMovieModel
    }

    @Test
    fun onUIReady_callDisplayAllData() {
        val lifeCycleOwner = mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        mPresenter.onUIReady(lifeCycleOwner)

        verify {
            mView.displayPopularMoviesList(getDummyMovies())
        }

        verify {
            mView.displayGenresList(getDummyGenres())
        }

        verify {
            mView.displayActorsList(getDummyActors())
        }

    }
}