package org.example.data

import org.example.data.model.ShoesDTO
import org.example.domain.Request.ShoesAddRequest
import org.example.domain.Response.ShoesResponse

interface ShoesRepository {
    fun addShoes(shoesAddRequest: ShoesAddRequest) : ShoesDTO
    fun getAllShoes() : List<ShoesDTO>
    fun updateShoes(shoesId: Int, updatedShoes : ShoesDTO) : ShoesDTO
    fun removeShoes(shoesId : Int) : Boolean
}