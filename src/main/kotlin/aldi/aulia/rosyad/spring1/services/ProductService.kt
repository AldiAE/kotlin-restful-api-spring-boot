package aldi.aulia.rosyad.spring1.services

import aldi.aulia.rosyad.spring1.models.CreateProductRequest
import aldi.aulia.rosyad.spring1.models.ListProductRequest
import aldi.aulia.rosyad.spring1.models.ProductResponse
import aldi.aulia.rosyad.spring1.models.UpdateProductRequest

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse

    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse

    fun delete(id: String)

    fun list(listProductRequest: ListProductRequest): List<ProductResponse>

}