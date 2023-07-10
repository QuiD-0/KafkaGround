package com.quid.kafkaground.push.gateway.controller;

import com.quid.kafkaground.push.gateway.controller.dto.PushMessageReq;
import com.quid.kafkaground.push.usecase.MessagePush;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/push")
public class PushController {

    private final MessagePush pushService;

    @PostMapping
    public void push(@RequestBody PushMessageReq message) {
        pushService.push(message);
    }
}
