package com.quid.kafkaground.push.service;

import com.quid.kafkaground.producer.PushProducer;
import com.quid.kafkaground.push.PushMessage;
import com.quid.kafkaground.push.dto.PushMessageReq;
import com.quid.kafkaground.push.repository.PushJpaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PushServiceImpl implements PushService {

    private final PushProducer pushProducer;
    private final PushJpaRepository repository;


    @Override
    public void push(PushMessageReq message) {
        List<PushMessage> pushMessages = message.toEntityList();
        pushProducer.push(pushMessages);
        log.info("Pushed message: {}", pushMessages);
        repository.saveAll(pushMessages);
    }
}