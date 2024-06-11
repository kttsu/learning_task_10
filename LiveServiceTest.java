package com.tsuchiya.live;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LiveServiceTest {

    @InjectMocks
    private LiveService liveService;

    @Mock
    private LiveMapper liveMapper;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll_Service() {
        Live live1 = new Live(1, "2024-6-6 19:00:00", "PRAYING MANTIS", "梅田Club Quattro");
        Live live2 = new Live(2, "2024-9-24 19:00:00", "IRON MAIDEN", "大阪城ホール");
        Live live3 = new Live(3, "2024-10-19 18:00:00", "JOURNEY", "Asueアリーナ大阪");
        Live live4 = new Live(4, "2024-10-02 19:00:00", "RHAPSODY OF FIRE", "梅田クラブクアトロ");

        List<Live> expected = Arrays.asList(live1, live2, live3, live4);
        when(liveMapper.findAll()).thenReturn(expected);

        List<Live> actual = liveMapper.findAll();

        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }
}

