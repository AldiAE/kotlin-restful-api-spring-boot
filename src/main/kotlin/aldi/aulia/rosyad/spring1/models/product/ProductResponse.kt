package aldi.aulia.rosyad.spring1.models

import java.util.*

data class ProductResponse(

    val id: String,

    val name: String,

    val price: Long,

    val quantity: Int,

    val createdAt: Date,

    val updatedAt: Date?

)