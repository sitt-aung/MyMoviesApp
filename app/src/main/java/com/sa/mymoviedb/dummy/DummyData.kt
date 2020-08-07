package com.sa.mymoviedb.dummy

import com.sa.mymoviedb.data.vos.GenreVO
import com.sa.mymoviedb.data.vos.MovieDetailsVO
import com.sa.mymoviedb.data.vos.MovieVO
import com.sa.mymoviedb.data.vos.PersonVO

fun getDummyMovies() : List<MovieVO> {
    val movies = mutableListOf<MovieVO>()

    for (i in 1..5) {
        movies.add(
            MovieVO(i, 100f, 200, false, "", false,
            "", "language $i", "Original Title $i", listOf(),
            "Title $i", 120f, "This is overview $i", "")
        )
    }

    return movies
}

fun getDummyActors() : List<PersonVO> {
    val actors = mutableListOf<PersonVO>()

    for (i in 1..5) {
        actors.add(
            PersonVO(i, "Name $i", "", false)
        )
    }

    return actors
}

fun getDummyGenres() : List<GenreVO> {
    val genres = mutableListOf<GenreVO>()

    for (i in 1..5) {
        genres.add(
            GenreVO(i, "Genre $i")
        )
    }

    return genres
}

fun getDummyDetails(movieId: Int) : MovieDetailsVO {
    return MovieDetailsVO(movieId, false, "", getDummyGenres())
}

