package aldi.aulia.rosyad.spring1.entities.apiweb

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "abouts")
data class About (

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    val id: String,

    @Column(name = "photo_url")
    var photo_url: String,

    @Column(name = "desc_first", columnDefinition = "TEXT")
    var desc_first: String,

    @Column(name = "desc_second", columnDefinition = "TEXT")
    var desc_second: String,

    @Column(name = "created_at")
    var createdAt: Date,

    @Column(name = "updated_at")
    var updatedAt: Date?

)