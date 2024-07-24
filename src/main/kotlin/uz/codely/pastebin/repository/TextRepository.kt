package uz.codely.pastebin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import uz.codely.pastebin.model.Text

@Repository
interface TextRepository : JpaRepository<Text, Int>