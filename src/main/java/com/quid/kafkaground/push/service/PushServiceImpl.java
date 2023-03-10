package com.quid.kafkaground.push.service;

import com.quid.kafkaground.producer.PushProducer;
import com.quid.kafkaground.push.PushMessage;
import com.quid.kafkaground.push.dto.PushMessageDto;
import com.quid.kafkaground.push.dto.PushMessageReq;
import com.quid.kafkaground.push.repository.PushRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PushServiceImpl implements PushService {

    private final PushProducer pushProducer;
    private final PushRepository pushRepository;


    @Override
    public void push(PushMessageReq message) {
        List<PushMessage> pushMessages = message.toEntityList();
        pushRepository.saveAll(pushMessages);
        pushProducer.push(pushMessages);
        log.info("Pushed message: {}", pushMessages);
    }

    @Override
    @Transactional
    public void updateSent(PushMessageDto message) {
        pushRepository.updateSent(message.id());
    }
}