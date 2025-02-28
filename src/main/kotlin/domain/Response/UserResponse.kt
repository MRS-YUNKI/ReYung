package domain.Response

import org.example.data.model.ShoesDTO
import org.example.domain.Response.ShoesResponse

data class UserResponse(
    val userId: Int,
    var firstName: String,
    var lastName: String? = null,
    var email: String,
    var phone: String? = null,
    var address: String? = null,
    val favouriteList: List<ShoesResponse> = emptyList()
)
