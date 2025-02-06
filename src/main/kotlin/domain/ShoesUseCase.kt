package org.example.domain

import org.example.data.model.ShoesDTO
import org.example.domain.Request.ShoesAddRequest
import org.example.domain.Response.ShoesResponse

interface ShoesUseCase {
    fun addShoes(shoesAddRequest: ShoesAddRequest): ShoesDTO
    fun removeShoesById(shoesId : Int) : Boolean
    fun getShoesList() : List<ShoesResponse>
}