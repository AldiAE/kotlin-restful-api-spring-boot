package aldi.aulia.rosyad.spring1.models.apiweb.home

import javax.validation.constraints.NotBlank

data class CreateHomeRequest (

    @field:NotBlank
    val id: String?,

    @field:NotBlank
    val name: String?,

    @field:NotBlank
    val short_about: String?

)