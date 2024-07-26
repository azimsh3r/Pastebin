package uz.codely.pastebin.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import uz.codely.pastebin.exceptionhandling.TextExpiredException
import uz.codely.pastebin.exceptionhandling.UserNotFoundException

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException::class)
    private fun handleUserNotFoundException(exception: RuntimeException) : ResponseEntity<out Any> {
        return ResponseEntity(exception.message, HttpStatus.NOT_FOUND)
    }
}