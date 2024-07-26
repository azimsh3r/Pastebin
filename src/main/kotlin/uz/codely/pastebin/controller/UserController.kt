package uz.codely.pastebin.controller

import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uz.codely.pastebin.exceptionhandling.ResponseMessage
import uz.codely.pastebin.model.User
import uz.codely.pastebin.service.UserService
import uz.codely.pastebin.util.UserValidator

@RestController
@RequestMapping("/user")
class UserController @Autowired constructor (private val userService: UserService, private val userValidator: UserValidator) {

    @PostMapping
    private fun create(@RequestBody @Valid user : User, bindingResult : BindingResult) : ResponseEntity<out Any> {
        userValidator.validate(user, bindingResult)
        if (bindingResult.hasErrors()) {
            val stringBuilder = StringBuilder()
            for (error in bindingResult.fieldErrors) {
                stringBuilder.append(error.defaultMessage).append(" ")
            }
            return ResponseEntity(ResponseMessage(stringBuilder.toString()), HttpStatus.BAD_REQUEST)
        }
        userService.save(user)
        return ResponseEntity(HttpStatus.OK)
    }
}
