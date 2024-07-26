package uz.codely.pastebin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import uz.codely.pastebin.model.User
import uz.codely.pastebin.repository.UserRepository
import java.util.*

@Service
class UserService @Autowired constructor(private val userRepository: UserRepository) {

    fun save (user: User) : User = userRepository.save(user)

    fun findAllByUsername (username: String) : List<User> = userRepository.findAllByUsername(username)

    fun findUserById(userId : Int) : Optional<User> = userRepository.findById(userId)
}
