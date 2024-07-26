package uz.codely.pastebin.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

class TextDTO {
    lateinit var text: String

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var hideUser : Boolean = false

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    lateinit var expiresAt : LocalDateTime
}