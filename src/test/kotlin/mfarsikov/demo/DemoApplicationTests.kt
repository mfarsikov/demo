package mfarsikov.demo

import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.io.File

/*
@AutoConfigureMockMvc
@RunWith(SpringRunner::class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    lateinit var mockMvc: MockMvc


    @Test
    fun test() {


        mockMvc.perform(get("/greeting"))
                .andExpect(status().isOk)


    }
}


*/
