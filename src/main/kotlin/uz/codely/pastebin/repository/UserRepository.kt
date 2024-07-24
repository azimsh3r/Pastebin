package uz.codely.pastebin.repository

import org.springframework.data.jpa.repository.JpaRepository
import uz.codely.pastebin.model.User

interface UserRepository : JpaRepository<User, Int>