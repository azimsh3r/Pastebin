package uz.codely.pastebin.model

import jakarta.persistence.*

@Entity
@Table(name="User")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id : Int = 0

    @Column(name="username")
    lateinit var username : String

    @OneToMany(mappedBy = "user")
    lateinit var textList : List<Text>
}
