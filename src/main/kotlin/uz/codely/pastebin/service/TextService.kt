package uz.codely.pastebin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import uz.codely.pastebin.exceptionhandling.UserNotFoundException
import uz.codely.pastebin.model.Text
import uz.codely.pastebin.model.User
import uz.codely.pastebin.repository.TextRepository
import java.util.*

@Service
class TextService @Autowired constructor(private val textRepository: TextRepository, private val userService: UserService) {
    fun save (text : Text) : Text {
        val user: Optional<User> = userService.findUserById(text.user.id)
        if (user.isPresent) {
            return textRepository.save(text)
        } else
            throw UserNotFoundException()
    }
}