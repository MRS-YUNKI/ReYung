package org.example.data

import org.example.data.model.ShoesDTO

interface ShoesRepository {
    fun addShoes()
    fun getAllShoes() : List<ShoesDTO>
    fun removeShoes(shoesId : Int) : Boolean
}