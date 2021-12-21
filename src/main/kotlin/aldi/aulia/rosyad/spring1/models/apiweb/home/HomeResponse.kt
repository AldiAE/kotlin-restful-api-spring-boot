package aldi.aulia.rosyad.spring1.models.apiweb.home

import java.util.*

data class HomeResponse(

    val id: String,

    val name: String,

    val short_abut: String,

    val createdAt: Date,

    val updatedAt: Date?

)