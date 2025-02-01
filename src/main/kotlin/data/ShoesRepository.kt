package org.example.data

import org.example.data.model.ShoesDTO
import org.example.domain.Request.ShoesAddRequest

interface ShoesRepository {
    fun addShoes(shoesAddRequest: ShoesAddRequest) : ShoesDTO
    fun updateShoes(shoesId: Int, updatedShoes: ShoesDTO) : ShoesDTO
    fun getAllShoes() : List<ShoesDTO>
    fun findShoesById(shoesId: Int) : ShoesDTO
    fun removeShoesById(shoesId : Int) : Boolean
}