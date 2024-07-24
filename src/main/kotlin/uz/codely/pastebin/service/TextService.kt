package uz.codely.pastebin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import uz.codely.pastebin.repository.TextRepository

@Service
class TextService @Autowired constructor(private final val textRepository: TextRepository)