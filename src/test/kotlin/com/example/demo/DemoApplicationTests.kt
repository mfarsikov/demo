package com.example.demo

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.util.ResourceUtils

@AutoConfigureMockMvc
@RunWith(SpringRunner::class)
@SpringBootTest
class DemoApplicationTests {


    @Autowired
    lateinit var mockMvc: MockMvc
    @Autowired
    lateinit var profileRepository: ProfileRepository

    @Test
    fun contextLoads() {

        val body = ResourceUtils.getFile("classpath:profiles.json").readText()
        mockMvc.perform(MockMvcRequestBuilders.post("/profiles").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(MockMvcResultMatchers.status().isOk)

        assert(profileRepository.findAll().size == 1000)

    }

}
