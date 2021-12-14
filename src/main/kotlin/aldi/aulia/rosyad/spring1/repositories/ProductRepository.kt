package aldi.aulia.rosyad.spring1.repositories

import aldi.aulia.rosyad.spring1.entities.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String> {

}