package uz.codely.pastebin.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name= "text")
class Text {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    var id : Int = 0

    @Column(name="text")
    @Size(min = 3, max = 100, message = "Text should be between 3 and 100 characters")
    @NotNull(message = "Text cannot be null")
    var text: String? = null

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    lateinit var user: User

    @Column(name = "hide_user")
    var hideUser : Boolean = false

    @OneToOne(mappedBy = "text")
    lateinit var hash: UrlHash
}
