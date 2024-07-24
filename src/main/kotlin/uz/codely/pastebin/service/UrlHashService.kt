package uz.codely.pastebin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import uz.codely.pastebin.repository.UrlHashRepository

@Service
class UrlHashService @Autowired constructor(private final val urlHashRepository: UrlHashRepository)