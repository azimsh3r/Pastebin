package uz.codely.pastebin.model

import jakarta.persistence.*

@Entity
@Table(name= "text")
class Text {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Int = 0

    @Column(name="text")
    var text: String? = null

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    lateinit var user: User

    @Column(name = "hide_user")
    var hideUser : Boolean = false
}
