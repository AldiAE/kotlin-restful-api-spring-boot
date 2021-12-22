package aldi.aulia.rosyad.spring1.models.apiweb.about

import javax.validation.constraints.NotBlank


data class CreateAboutRequest (

    @field:NotBlank
    val id: String?,

    @field:NotBlank
    val photo_url: String?,

    @field:NotBlank
    val desc_first: String?,

    @field:NotBlank
    val desc_second: String?,
)