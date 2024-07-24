package uz.codely.pastebin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import uz.codely.pastebin.repository.UserRepository

@Service
class UserService @Autowired constructor(private val userRepository: UserRepository)
