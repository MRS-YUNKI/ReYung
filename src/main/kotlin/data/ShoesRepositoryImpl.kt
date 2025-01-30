package org.example.data

import org.example.data.ShoesRepository
import org.example.data.model.ShoesDTO

class ShoesRepositoryImpl : ShoesRepository {
    private val shoesSource : MutableList<ShoesDTO> = shoesList.toMutableList()

    override fun AddShoes() {
        val newShoes = ShoesDTO(
            shoesId = shoesSource.size + 1,
            shoesName = ,
            shoesDesc = ,
            shoesUrl = ,
            category =
        )
        shoesSource.add(newShoes)
        return newShoes
    }

    override fun getAllShoes() : List<ShoesDTO> = shoesSource

    override fun removeShoesById(shoesId: Int) : Boolean {
        return shoesSource.removeIf { it.shoesId == shoesId }
    }
}
