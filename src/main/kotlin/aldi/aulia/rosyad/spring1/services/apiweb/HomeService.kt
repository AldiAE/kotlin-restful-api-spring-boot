package aldi.aulia.rosyad.spring1.services.apiweb

import aldi.aulia.rosyad.spring1.models.apiweb.home.CreateHomeRequest
import aldi.aulia.rosyad.spring1.models.apiweb.home.HomeResponse
import aldi.aulia.rosyad.spring1.models.apiweb.home.ListHomeRequest
import aldi.aulia.rosyad.spring1.models.apiweb.home.UpdateHomeRequest

interface HomeService {

    fun create(createHomeRequest: CreateHomeRequest):HomeResponse

    fun get(id: String): HomeResponse

    fun update(id: String, updateHomeRequest: UpdateHomeRequest): HomeResponse

    fun delete(id: String)

    fun list(listHomeRequest: ListHomeRequest): List<HomeResponse>
}