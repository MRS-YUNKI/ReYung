package org.example.data

import com.sun.security.jgss.InquireType
import org.example.data.model.FavouriteDTO
import org.example.domain.Request.AddFavouriteRequest

class FavouriteRepositoryImpl : FavouriteRepository {
    val favouriteList = favouriteListSource.toMutableList()
    override fun getAllFavourites() : List<FavouriteDTO> = favouriteList

    override fun addFavourites(vararg addFavouriteRequest: AddFavouriteRequest) {
        val newFavourite = FavouriteDTO(

        )
    }

    override fun removeFromFavourites() {
        TODO("Not yet implemented")
    }

    override fun getFavouriteByUserId(userId: Int):  IntArray {
        return favouriteList
            .filter
    }
}