package clean_architecture.domain.usecase

import clean_architecture.domain.model.UserName
import clean_architecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository){

    fun execute(): UserName {
        return userRepository.getName();
    }
}