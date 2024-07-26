package uz.codely.pastebin.exceptionhandling

import java.time.LocalDateTime

class ResponseMessage (val message : String, val timeStamp: LocalDateTime = LocalDateTime.now())