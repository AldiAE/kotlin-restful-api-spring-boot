package aldi.aulia.rosyad.spring1.services.impl.apiweb

import aldi.aulia.rosyad.spring1.entities.apiweb.About
import aldi.aulia.rosyad.spring1.models.apiweb.about.AboutResponse
import aldi.aulia.rosyad.spring1.models.apiweb.about.CreateAboutRequest
import aldi.aulia.rosyad.spring1.models.apiweb.about.ListAboutRequest
import aldi.aulia.rosyad.spring1.models.apiweb.about.UpdateAboutRequest
import aldi.aulia.rosyad.spring1.repositories.apiweb.AboutRepository
import aldi.aulia.rosyad.spring1.services.apiweb.AboutService
import aldi.aulia.rosyad.spring1.validations.ValidationUtil
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class AboutServiceImpl(
    val aboutRepository: AboutRepository,
    val validationUtil: ValidationUtil
): AboutService {
    override fun create(createAboutRequest: CreateAboutRequest): AboutResponse {
        validationUtil.validate(createAboutRequest)

        val about = About(
            id = createAboutRequest.id!!,
            photo_url = createAboutRequest.photo_url!!,
            desc_first = createAboutRequest.desc_first!!,
            desc_second = createAboutRequest.desc_second!!,
            createdAt = Date(),
            updatedAt = null
        )

        aboutRepository.save(about)

        return convertAboutToAboutResponse(about)
    }

    override fun get(id: String): AboutResponse {
        val about =  findAboutByIdOrThrowNotFound(id)
        return convertAboutToAboutResponse(about)
    }

    override fun update(id: String, updateAboutRequest: UpdateAboutRequest): AboutResponse {
        val about = findAboutByIdOrThrowNotFound(id)

        validationUtil.validate(updateAboutRequest)

        about.apply {
            photo_url = updateAboutRequest.photo_url!!
            desc_first = updateAboutRequest.desc_first!!
            desc_second = updateAboutRequest.desc_second!!
            updatedAt = Date()
        }

        aboutRepository.save(about)

        return convertAboutToAboutResponse(about)
    }

    override fun delete(id: String) {
        val about = findAboutByIdOrThrowNotFound(id)
        aboutRepository.delete(about)
    }

    override fun list(listAboutRequest: ListAboutRequest): List<AboutResponse> {
        val page = aboutRepository.findAll(PageRequest.of(listAboutRequest.page, listAboutRequest.size))
        val abouts: List<About> = page.get().collect(Collectors.toList())
        return abouts.map { convertAboutToAboutResponse(it) }
    }

    private fun findAboutByIdOrThrowNotFound(id: String): About {
        val about = aboutRepository.findByIdOrNull(id)
        if (about == null) {
            throw ChangeSetPersister.NotFoundException()
        } else {
            return about
        }
    }

    private fun convertAboutToAboutResponse(about: About): AboutResponse {
        return AboutResponse(
            id = about.id,
            photo_url = about.photo_url,
            desc_first = about.desc_first,
            desc_second = about.desc_second,
            createdAt = about.createdAt,
            updatedAt = about.updatedAt
        )
    }
}