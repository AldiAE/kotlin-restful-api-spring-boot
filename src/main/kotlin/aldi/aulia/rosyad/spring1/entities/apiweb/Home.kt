package aldi.aulia.rosyad.spring1.entities.apiweb

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "homes")
data class Home (

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    val id: String,

    @Column(name = "name")
    var name: String,

    @Column(name = "short_about", columnDefinition = "TEXT")
    var short_about: String,

    @Column(name = "created_at")
    var createdAt: Date,

    @Column(name = "updated_at")
    var updatedAt: Date?

)