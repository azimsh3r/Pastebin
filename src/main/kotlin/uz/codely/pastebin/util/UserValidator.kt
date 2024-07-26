package uz.codely.pastebin.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator
import uz.codely.pastebin.model.User
import uz.codely.pastebin.service.UserService

@Component
class UserValidator @Autowired constructor(private val userService : UserService) : Validator {
    override fun supports(clazz: Class<*>): Boolean = clazz::class.java == User::class

    override fun validate(target: Any, errors: Errors) {
        val user : User = target as User

        if (userService.findAllByUsername(user.username).isNotEmpty()) {
            errors.rejectValue("username", "", "User with this username already exists!")
        }
    }
}