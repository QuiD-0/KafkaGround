package com.quid.kafkaground.push.controller;

import com.quid.kafkaground.push.dto.PushMessageReq;
import com.quid.kafkaground.push.service.PushService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/push")
public class PushController {

    private final PushService pushService;
    @PostMapping
    public void push(@RequestBody PushMessageReq message) {
        pushService.push(message);
    }
}
