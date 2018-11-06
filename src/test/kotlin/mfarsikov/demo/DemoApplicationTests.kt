package mfarsikov.demo

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.util.ResourceUtils
import javax.sql.DataSource

@AutoConfigureMockMvc
@RunWith(SpringRunner::class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    lateinit var mockMvc: MockMvc
    @Autowired
    lateinit var profileRepository: ProfileRepository

    @Test
    fun post1000Profiles() {

        val body = ResourceUtils.getFile("classpath:profiles.json").readText()

        mockMvc.perform(post("/profiles")
                                .contentType(APPLICATION_JSON)
                                .content(body))
                .andExpect(status().isOk)

        assert(profileRepository.findAll().size == 1000)

    }
}

@Configuration
class TestContext {

    @Primary
    @Bean
    fun dataSource(): DataSource = DriverManagerDataSource().apply {
        setDriverClassName("org.h2.Driver")
        url = "jdbc:h2:mem:db;DB_CLOSE_DELAY=-1;MODE=PostgreSQL"
    }
}
