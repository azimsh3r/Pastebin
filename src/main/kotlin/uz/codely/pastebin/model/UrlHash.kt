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

    @OneToOne
    @JoinColumn(name = "text_id", referencedColumnName = "id")
    lateinit var text: Text

    @Column(name = "url")
    lateinit var url : String

    @Column(name = "created_at")
    val createdAt : LocalDateTime = LocalDateTime.now()

    @Column(name = "expires_at")
    lateinit var expiresAt: LocalDateTime
}
