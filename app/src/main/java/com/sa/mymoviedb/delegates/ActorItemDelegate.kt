package com.sa.mymoviedb.delegates

interface ActorItemDelegate {
    fun onTapFavorite(personId: Int, favorite: Boolean)
}