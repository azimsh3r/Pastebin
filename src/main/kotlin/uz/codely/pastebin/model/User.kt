package uz.codely.pastebin.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name="service_user")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    var id : Int = 0

    @Column(name="username")
    @Size(min = 3, max = 32, message = "Username should be between 3 and 32 characters!")
    @NotNull(message = "Username cannot be null")
    lateinit var username : String

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    lateinit var textList : List<Text>
}
