package com.tsuchiya.live;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LiveServiceTest {

    @InjectMocks
    private LiveService liveService;

    @Mock
    private LiveMapper liveMapper;


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

    @Test
    public void testFindById_Service() {
        int existingId = 1;
        Live expectedLive = new Live(existingId, "2024-06-06 19:00:00", "PRAYING MANTIS", "梅田Club Quattro");
        when(liveMapper.findById(existingId)).thenReturn(Optional.of(expectedLive));

        Live actualLive = liveService.findById(existingId);

        assertEquals(expectedLive, actualLive);
    }

    @Test
    public void testFindById_Exception_Service() {
        int nonExistingId = 6;

        when(liveMapper.findById(nonExistingId)).thenReturn(Optional.empty());

        assertThrows(LiveNotFoundException.class, () -> liveService.findById(nonExistingId));
    }
}

