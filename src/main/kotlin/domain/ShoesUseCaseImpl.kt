package org.example.domain

import org.example.data.ShoesRepository
import org.example.data.model.ShoesDTO
import org.example.data.shoesList
import org.example.domain.Request.ShoesAddRequest

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
}
//в интерфейсе описываем базовые действия над объектом:
// обновление (+), удаление (+), чтение (+), чтение одного объекта (+),
// чтениям с фильтром, вывод всей информации,
// (?) чтение с фильтром
// (?) добавление объектов в локал сторадж добавляем переменную с локальными объектами