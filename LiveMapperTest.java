package com.tsuchiya.live;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LiveMapperTest {

    @Autowired
    LiveMapper liveMapper;

    @Test
    @DataSet(value = "datasets/live.yml")
    @Transactional
    void 全てのliveを取得できること() {
        List<Live> live = liveMapper.findAll();
    }

    @Test
    @DataSet(value = "datasets/live.yml")
    @Transactional
    void 存在するliveのidを指定して取得できること() {
        Optional<Live> live = liveMapper.findById(1);
        assertThat(live).isPresent();

        Live expectedLive = new Live(1, "2024-05-09 19:00:00", "Yngwie J.Malmsteen", "zepp namba");
        assertThat(live.get()).isEqualTo(expectedLive);
    }

    @Test
    @Transactional
    void 存在しないliveのidを指定した時にOptionalemptyが返されること() {
        Optional<Live> live = liveMapper.findById(5);
        assertThat(live).isEmpty();
    }

    @Test
    @DataSet(value = "datasets/live.yml")
    @Transactional
    void liveを新規登録できること() {
        Live live = new Live("2024-12-31 20:00:00", "NEW TEST LIVE", "NEW LOCATION");
        liveMapper.insert(live);
    }
}

