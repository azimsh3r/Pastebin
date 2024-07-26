package uz.codely.pastebin.controller

import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uz.codely.pastebin.dto.TextDTO
import uz.codely.pastebin.dto.UrlHashDTO
import uz.codely.pastebin.exceptionhandling.UserNotFoundException
import uz.codely.pastebin.model.Text
import uz.codely.pastebin.model.UrlHash
import uz.codely.pastebin.service.TextService
import uz.codely.pastebin.service.UrlHashService

@RestController
@RequestMapping("/text")
class TextController @Autowired constructor(private val textService : TextService, private val hashService: UrlHashService, private val modelMapper: ModelMapper){

    @PostMapping
    fun createNote(@RequestBody textDTO : TextDTO) : ResponseEntity<out Any> {
        //TODO: As we cannot store newlines in postgres, make sure to use delimiters
        return ResponseEntity(
            convertUrlModelTODTO(
                hashService.saveByText(
                    textService.save(
                        convertTextDTOToModel(textDTO)
                    ),
                    textDTO.expiresAt
                )
            ),
            HttpStatus.OK
        )
    }

    @GetMapping("/{url}")
    fun getNote(@PathVariable("url") url : String) : ResponseEntity<out Any> {
        return ResponseEntity (
            hashService.findTextByUrlHash(url),
            HttpStatus.OK
        );
    }

    fun convertTextDTOToModel(text: TextDTO) : Text = modelMapper.map(text, Text::class.java)

    fun convertUrlModelTODTO(urlHash: UrlHash) : UrlHashDTO = modelMapper.map(urlHash, UrlHashDTO::class.java)
}
