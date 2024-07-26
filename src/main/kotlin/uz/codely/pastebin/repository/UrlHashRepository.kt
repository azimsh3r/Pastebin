package uz.codely.pastebin.repository

import org.springframework.data.jpa.repository.JpaRepository
import uz.codely.pastebin.model.UrlHash
import java.util.Optional

interface UrlHashRepository : JpaRepository<UrlHash, Int> {
    fun findByUrl(url : String) : Optional<UrlHash>
}
