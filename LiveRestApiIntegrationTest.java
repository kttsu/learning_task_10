package com.tsuchiya.live;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

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
    void 全てのliveを取得するテスト() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/live"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
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
}

