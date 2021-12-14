package aldi.aulia.rosyad.spring1.repositories

import aldi.aulia.rosyad.spring1.entities.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository : JpaRepository<ApiKey, String> {
}