package uz.codely.pastebin.exceptionhandling

import java.time.LocalDateTime

class TextNotFoundException (override var message : String = "Text with this url is not found") : RuntimeException (message) {
    var timestamp : LocalDateTime = LocalDateTime.now()
}