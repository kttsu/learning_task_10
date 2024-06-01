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

    public void update(Integer id, String schedule, String name, String location) {
        Optional<Live> liveOptional = liveMapper.findById(id);
        Live live = liveOptional.orElseThrow(() -> new LiveNotFoundException("That id live is not registered"));

        // 既存のレコードと同じ場合は更新しない。
        if (liveMapper.isDuplicate(schedule, name, location, id)) {
            throw new SameLiveDataException("Cannot update with the same data");
        }

        // ライブ情報が見つかった場合に更新処理を行う。
        live.setSchedule(schedule);
        live.setName(name);
        live.setLocation(location);
        liveMapper.update(live);
    }
}

