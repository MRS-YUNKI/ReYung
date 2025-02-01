package org.example.data

import org.example.data.model.ShoesDTO
import org.example.data.model.UserDTO
import org.example.domain.Request.ShoesAddRequest

class ShoesRepositoryImpl : ShoesRepository {
    private val shoesSource = shoesList.toMutableList()
    override fun addShoes(shoesAddRequest: ShoesAddRequest): ShoesDTO {
        val newShoes = ShoesDTO(
            shoesId = shoesSource.size + 1,
            shoesName = shoesAddRequest.shoesName,
            shoesDescription = shoesAddRequest.shoesDescription,
            shoesUrl = shoesAddRequest.shoesUrl,
            category = shoesAddRequest.category
        )
        shoesSource.add(newShoes)
        return newShoes
    }

    override fun getAllShoes() : List<ShoesDTO> = shoesSource

    override fun updateShoes(shoesId: Int, updatedShoes: ShoesDTO): ShoesDTO {
        val oldShoes = shoesSource.first { it.shoesId == shoesId }
        checkNotNull(oldShoes)
        oldShoes.shoesName = updatedShoes.shoesName
        oldShoes.shoesDescription = updatedShoes.shoesDescription
        oldShoes.shoesUrl = updatedShoes.shoesUrl
        oldShoes.category = updatedShoes.category
        return oldShoes
    }

    override fun removeShoes(shoesId: Int) : Boolean {
        return shoesSource.removeIf { it.shoesId == shoesId }
    }
}