package com.tsuchiya.live;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DBRider
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LiveRestApiIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DataSet(value = "datasets/live.yml")
    @Transactional
    void 全てのliveを取得できること() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/live"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                           {
                             "id": 1,
                             "schedule": "2024-05-09 19:00:00",
                             "name": "Yngwie J.Malmsteen",
                             "location": "zepp namba"
                           },
                           {
                             "id": 2,
                             "schedule": "2024-06-06 19:00:00",
                             "name": "PRAYING MANTIS",
                             "location": "梅田Club Quattro"
                           },
                           {
                             "id": 3,
                             "schedule": "2024-09-24 19:00:00",
                             "name": "IRON MAIDEN",
                             "location": "大阪城ホール"
                           },
                           {
                             "id": 4,
                             "schedule": "2024-10-19 18:00:00",
                             "name": "JOURNEY",
                             "location": "Asueアリーナ大阪"
                           }
                        ]
                        """
                ));
    }

    @Test
    @DataSet(value = "datasets/live.yml")
    @Transactional
    void 存在するliveのidを指定して取得できること() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/live/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""                  
                           {
                             "id": 1,
                             "schedule": "2024-05-09 19:00:00",
                             "name": "Yngwie J.Malmsteen",
                             "location": "zepp namba"
                           }
                        """
                ));
    }

    @Test
    @Transactional
    void 存在しないliveのidを指定したときに404エラーが返されること() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/live/5"))
                .andExpect(status().isNotFound())
                .andExpect(content().json("""                              
                           {
                             "message": "Live not found"
                           }
                        """
                ));
    }

    @Test
    @DataSet(value = "datasets/live.yml")
    @Transactional
    void liveを新規登録できること() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/live")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                          "schedule": "2024-12-31 20:00:00",
                          "name": "NEW TEST LIVE",
                          "location": "NEW LOCATION"
                        }
                        """));
    }
}

