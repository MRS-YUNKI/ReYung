package org.example.domain

import org.example.data.ShoesRepository
import org.example.data.model.ShoesDTO
import org.example.data.shoesList
import org.example.domain.Request.ShoesAddRequest
import org.example.domain.Response.ShoesResponse

class ShoesUseCaseImpl (private val shoesRepository: ShoesRepository) : ShoesUseCase {
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

    override fun removeShoesById(shoesId: Int): Boolean {
        return shoesSource.removeIf { it.shoesId == shoesId }
    }

    override fun getShoesList(): List<ShoesResponse> {
        val shoesList = shoesRepository.getAllShoes().map {
            ShoesDTOtoUserResponse(it)
        }
        return shoesList
    }
}
//в интерфейсе описываем базовые действия над объектом:
// обновление (+), удаление (+), чтение (+), чтение одного объекта (+),
// вывод всей информации (+),
// (?) чтение с фильтром