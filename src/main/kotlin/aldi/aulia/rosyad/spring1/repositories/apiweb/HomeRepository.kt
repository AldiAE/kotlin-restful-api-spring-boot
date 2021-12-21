package aldi.aulia.rosyad.spring1.repositories.apiweb

import aldi.aulia.rosyad.spring1.entities.apiweb.Home
import org.springframework.data.jpa.repository.JpaRepository

interface HomeRepository: JpaRepository<Home, String> {
}