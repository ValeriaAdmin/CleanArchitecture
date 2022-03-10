package clean_architecture.domain.repository

import clean_architecture.domain.model.SaveUserNameModel
import clean_architecture.domain.model.UserName

interface UserRepository {

    fun saveName(saveNameParam: SaveUserNameModel) : Boolean

    fun getName(): UserName
}