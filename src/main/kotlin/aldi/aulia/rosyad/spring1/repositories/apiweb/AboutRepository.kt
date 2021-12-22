package aldi.aulia.rosyad.spring1.repositories.apiweb

import aldi.aulia.rosyad.spring1.entities.apiweb.About
import org.springframework.data.jpa.repository.JpaRepository

interface AboutRepository: JpaRepository<About, String> {
}