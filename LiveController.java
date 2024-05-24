package com.tsuchiya.live;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class LiveController {
   private final LiveService liveService;
   public LiveController(LiveService liveService) {
       this.liveService = liveService;
   }


@PostMapping("/live")
public ResponseEntity<LiveResponse> insert(@RequestBody LiveRequest liveRequest, UriComponentsBuilder uriBuilder) {
    Live live = liveService.insert(liveRequest.getSchedule(), liveRequest.getName(), liveRequest.getLocation());
    URI location = uriBuilder.path("/live/{id}").buildAndExpand(live.getId()).toUri();
    LiveResponse body = new LiveResponse("live created");
    return ResponseEntity.created(location).body(body);
   }
}

