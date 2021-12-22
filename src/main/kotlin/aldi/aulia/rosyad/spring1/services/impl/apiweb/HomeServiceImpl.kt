package aldi.aulia.rosyad.spring1.services.impl.apiweb

import aldi.aulia.rosyad.spring1.entities.apiweb.Home
import aldi.aulia.rosyad.spring1.models.apiweb.home.CreateHomeRequest
import aldi.aulia.rosyad.spring1.models.apiweb.home.HomeResponse
import aldi.aulia.rosyad.spring1.models.apiweb.home.ListHomeRequest
import aldi.aulia.rosyad.spring1.models.apiweb.home.UpdateHomeRequest
import aldi.aulia.rosyad.spring1.repositories.apiweb.HomeRepository
import aldi.aulia.rosyad.spring1.services.apiweb.HomeService
import aldi.aulia.rosyad.spring1.validations.ValidationUtil
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class HomeServiceImpl(
    val homeRepository: HomeRepository,
    val validationUtil: ValidationUtil
): HomeService {
    override fun create(createHomeRequest: CreateHomeRequest): HomeResponse {
        validationUtil.validate(createHomeRequest)

        val home = Home(
            id = createHomeRequest.id!!,
            name = createHomeRequest.name!!,
            short_about = createHomeRequest.short_about!!,
            createdAt = Date(),
            updatedAt = null
        )

        homeRepository.save(home)

        return convertHomeToHomeResponse(home)
    }

    override fun get(id: String): HomeResponse {
        val home = findHomeByIdOrThrowNotFound(id)
        return convertHomeToHomeResponse(home)
    }

    override fun update(id: String, updateHomeRequest: UpdateHomeRequest): HomeResponse {
        val home = findHomeByIdOrThrowNotFound(id)

        validationUtil.validate(updateHomeRequest)

        home.apply {
            name = updateHomeRequest.name!!
            short_about = updateHomeRequest.short_about!!
            updatedAt = Date()
        }

        homeRepository.save(home)

        return convertHomeToHomeResponse(home)
    }

    override fun delete(id: String) {
        val home = findHomeByIdOrThrowNotFound(id)
        homeRepository.delete(home)
    }

    override fun list(listHomeRequest: ListHomeRequest): List<HomeResponse> {
        val page = homeRepository.findAll(PageRequest.of(listHomeRequest.page, listHomeRequest.size))
        val homes: List<Home> = page.get().collect(Collectors.toList())
        return homes.map { convertHomeToHomeResponse(it) }
    }

    private fun findHomeByIdOrThrowNotFound(id: String): Home {
        val home = homeRepository.findByIdOrNull(id)
        if (home == null) {
            throw ChangeSetPersister.NotFoundException()
        } else {
            return home
        }
    }

    private fun convertHomeToHomeResponse(home: Home): HomeResponse {
        return HomeResponse(
            id = home.id,
            name = home.name,
            short_about = home.short_about,
            createdAt = home.createdAt,
            updatedAt = home.updatedAt
        )
    }
}