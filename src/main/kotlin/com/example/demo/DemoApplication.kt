package com.example.demo

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@RestController
class Controller(
        val profileRepository: ProfileRepository
) {
    @PostMapping("/profiles")
    fun save(@RequestBody profiles: List<ProfileDto>) {
        profileRepository.saveAll(profiles.map { it.toModel() })
    }

}

fun ProfileDto.toModel() = Profile(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        gender = gender,
        ipAddress = ipAddress
)


@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class ProfileDto(
        val id: Long,
        val firstName: String,
        val lastName: String,
        val email: String,
        val gender: String,
        val ipAddress: String
)


@Entity
data class Profile(
        @Id
        val uuid: UUID = UUID.randomUUID(),
        val id: Long,
        val firstName: String,
        val lastName: String,
        val email: String,
        val gender: String,
        val ipAddress: String
)

interface ProfileRepository : JpaRepository<Profile, UUID>