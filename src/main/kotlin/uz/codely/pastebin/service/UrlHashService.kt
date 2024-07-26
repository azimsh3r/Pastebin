package uz.codely.pastebin.service

import org.hibernate.Hibernate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import uz.codely.pastebin.exceptionhandling.TextExpiredException
import uz.codely.pastebin.exceptionhandling.TextNotFoundException
import uz.codely.pastebin.model.Text
import uz.codely.pastebin.model.UrlHash
import uz.codely.pastebin.repository.UrlHashRepository
import java.time.LocalDateTime
import java.util.Optional

@Service
class UrlHashService @Autowired constructor(private val urlHashRepository: UrlHashRepository) {
    companion object {
        val BASEURL : String = "http://localhost:8080/"
    }

    fun saveByText (text: Text, expiresAt: LocalDateTime) : UrlHash {
        val hash = UrlHash()
        hash.text = text
        hash.expiresAt = expiresAt
        hash.url = BASEURL + getUniqueHash()
        return urlHashRepository.save(hash)
    }

    private fun getUniqueHash () : String {
        TODO("Come up with the way to get unique hash")
    }

    fun findTextByUrlHash(hash : String) : Text {
        val urlHash : Optional<UrlHash> = urlHashRepository.findByUrl(hash)
        if (urlHash.isPresent) {
            if (urlHash.get().expiresAt.isBefore(LocalDateTime.now())) {
                Hibernate.initialize(urlHash.get().text)
                return urlHash.get().text
            }
            throw TextExpiredException()
        }
        throw TextNotFoundException()
    }
}
