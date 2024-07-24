package uz.codely.pastebin.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name="hash_data")
class UrlHash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int = 0

    @Column(name = "text_id")
    var textId: Int = 0

    @Column(name = "url")
    lateinit var url : String

    @Column(name = "created_at")
    val createdAt : LocalDateTime = LocalDateTime.now()

    @Column(name = "expires_at")
    lateinit var expiresAt: String
}
