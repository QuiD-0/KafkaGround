package com.quid.kafkaground.push.service;

import com.quid.kafkaground.producer.PushProducer;
import com.quid.kafkaground.push.dto.PushMessageReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PushServiceImpl implements PushService {

    private final PushProducer pushProducer;
    @Override
    public void push(PushMessageReq message) {
        pushProducer.push(message);
        log.info("Pushed message: {}", message);
    }
}