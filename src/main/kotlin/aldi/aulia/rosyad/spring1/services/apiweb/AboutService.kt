package aldi.aulia.rosyad.spring1.services.apiweb

import aldi.aulia.rosyad.spring1.models.apiweb.about.AboutResponse
import aldi.aulia.rosyad.spring1.models.apiweb.about.CreateAboutRequest
import aldi.aulia.rosyad.spring1.models.apiweb.about.ListAboutRequest
import aldi.aulia.rosyad.spring1.models.apiweb.about.UpdateAboutRequest

interface AboutService {

    fun create(createAboutRequest: CreateAboutRequest): AboutResponse

    fun get(id: String): AboutResponse

    fun update(id: String, updateAboutRequest: UpdateAboutRequest): AboutResponse

    fun delete(id: String)

    fun list(listAboutRequest: ListAboutRequest): List<AboutResponse>
}