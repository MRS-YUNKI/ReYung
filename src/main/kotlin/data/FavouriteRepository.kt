package org.example.data

import org.example.data.model.FavouriteDTO
import org.example.domain.Request.AddFavouriteRequest

interface FavouriteRepository {
    fun getAllFavourites() : List<FavouriteDTO>
    fun addFavourites(vararg addFavouriteRequest: AddFavouriteRequest)
    fun removeFromFavourites()
    fun getFavouriteByUserId(userId: Int) : IntArray
}