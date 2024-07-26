package uz.codely.pastebin.exceptionhandling

import java.time.LocalDateTime

class TextExpiredException (override var message  : String = "Text with this url expired") : RuntimeException(message) {
    val timestamp : LocalDateTime = LocalDateTime.now()
}