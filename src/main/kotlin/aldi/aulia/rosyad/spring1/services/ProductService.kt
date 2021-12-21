package aldi.aulia.rosyad.spring1.services

import aldi.aulia.rosyad.spring1.models.product.CreateProductRequest
import aldi.aulia.rosyad.spring1.models.product.ListProductRequest
import aldi.aulia.rosyad.spring1.models.product.ProductResponse
import aldi.aulia.rosyad.spring1.models.product.UpdateProductRequest

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse

    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse

    fun delete(id: String)

    fun list(listProductRequest: ListProductRequest): List<ProductResponse>

}