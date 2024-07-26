package uz.codely.pastebin.exceptionhandling

import java.time.LocalDateTime

class UserNotFoundException (override var message : String = "User with this id is not found!") : RuntimeException (message){
    val timestamp : LocalDateTime = LocalDateTime.now()
}