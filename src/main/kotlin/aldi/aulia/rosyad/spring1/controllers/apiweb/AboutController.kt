package aldi.aulia.rosyad.spring1.controllers.apiweb

import aldi.aulia.rosyad.spring1.models.WebResponse
import aldi.aulia.rosyad.spring1.models.apiweb.about.AboutResponse
import aldi.aulia.rosyad.spring1.models.apiweb.about.CreateAboutRequest
import aldi.aulia.rosyad.spring1.models.apiweb.about.ListAboutRequest
import aldi.aulia.rosyad.spring1.models.apiweb.about.UpdateAboutRequest
import aldi.aulia.rosyad.spring1.services.apiweb.AboutService
import org.springframework.web.bind.annotation.*

@RestController
class AboutController(val aboutService: AboutService) {

    @PostMapping(
        value = ["/api/personalweb/abouts"],
        produces = ["application/json"],
        consumes =  ["application/json"]
    )
    fun createAbout(@RequestBody body: CreateAboutRequest): WebResponse<AboutResponse> {
        val aboutResponse = aboutService.create(body)
        return WebResponse(
            code = 200,
            status = "OK",
            data = aboutResponse
        )
    }

    @GetMapping(
        value = ["/api/personalweb/abouts/{idAbout}"],
        produces = ["application/json"]
    )
    fun getAbout(@PathVariable("idAbout") id: String): WebResponse<AboutResponse> {
        val aboutResponse = aboutService.get(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = aboutResponse
        )
    }

    @PutMapping(
        value = ["/api/personalweb/abouts/{idAbout}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateAbout(@PathVariable("idAbout") id: String,
                   @RequestBody updateAboutRequest: UpdateAboutRequest
    ): WebResponse<AboutResponse> {
        val aboutResponse = aboutService.update(id, updateAboutRequest)
        return WebResponse(
            code = 200,
            status = "OK",
            data = aboutResponse
        )
    }

    @DeleteMapping(
        value = ["/api/personalweb/abouts/{idAbout}"],
        produces = ["application/json"]
    )
    fun deleteAbout(@PathVariable("idAbout") id: String): WebResponse<String> {
        aboutService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(
        value = ["/api/personalweb/abouts"],
        produces = ["application/json"]
    )
    fun listAbouts(@RequestParam(value = "size", defaultValue = "10") size: Int,
                  @RequestParam(value = "page", defaultValue = "0") page: Int): WebResponse<List<AboutResponse>> {
        val request = ListAboutRequest(page = page, size = size)
        val responses = aboutService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = responses
        )
    }
}