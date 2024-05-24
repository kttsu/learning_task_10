package com.tsuchiya.live;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LiveService {
    private final LiveMapper liveMapper;


    public LiveService(LiveMapper liveMapper) {
        this.liveMapper = liveMapper;
    }



    public Live insert(String schedule, String name, String location) {
        Live live = new Live(schedule, name, location);
        liveMapper.insert(live);
        return live;

    }

}

