package aldi.aulia.rosyad.spring1.models.apiweb.about

import java.util.*

data class AboutResponse (

    val id: String,

    val photo_url: String,

    val desc_first: String,

    val desc_second: String,

    val createdAt: Date,

    val updatedAt: Date?
)