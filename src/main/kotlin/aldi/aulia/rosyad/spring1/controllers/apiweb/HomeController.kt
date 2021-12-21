package aldi.aulia.rosyad.spring1.controllers.apiweb

import aldi.aulia.rosyad.spring1.models.WebResponse
import aldi.aulia.rosyad.spring1.models.apiweb.home.CreateHomeRequest
import aldi.aulia.rosyad.spring1.models.apiweb.home.HomeResponse
import aldi.aulia.rosyad.spring1.models.apiweb.home.ListHomeRequest
import aldi.aulia.rosyad.spring1.models.apiweb.home.UpdateHomeRequest
import aldi.aulia.rosyad.spring1.services.apiweb.HomeService
import org.springframework.web.bind.annotation.*

@RestController
class HomeController(val homeService: HomeService) {

    @PostMapping(
        value = ["/api/personalweb/homes"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createHome(@RequestBody body: CreateHomeRequest): WebResponse<HomeResponse> {
        val homeResponse = homeService.create(body)
        return WebResponse(
            code = 200,
            status = "OK",
            data = homeResponse
        )
    }

    @GetMapping(
        value = ["/api/personalweb/homes/{idHome}"],
        produces = ["application/json"]
    )
    fun getHome(@PathVariable("idHome") id: String): WebResponse<HomeResponse> {
        val homeResponse = homeService.get(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = homeResponse
        )
    }

    @PutMapping(
        value = ["/api/personalweb/homes/{idHome}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateHome(@PathVariable("idHome") id: String,
                      @RequestBody updateHomeRequest: UpdateHomeRequest
    ): WebResponse<HomeResponse> {
        val homeResponse = homeService.update(id, updateHomeRequest)
        return WebResponse(
            code = 200,
            status = "OK",
            data = homeResponse
        )
    }

    @DeleteMapping(
        value = ["/api/personalweb/homes/{idHome}"],
        produces = ["application/json"]
    )
    fun deleteHome(@PathVariable("idHome") id: String): WebResponse<String> {
        homeService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(
        value = ["/api/personalweb/homes"],
        produces = ["application/json"]
    )
    fun listHomes(@RequestParam(value = "size", defaultValue = "10") size: Int,
                     @RequestParam(value = "page", defaultValue = "0") page: Int): WebResponse<List<HomeResponse>> {
        val request = ListHomeRequest(page = page, size = size)
        val responses = homeService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = responses
        )
    }
}
