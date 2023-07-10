package com.quid.kafkaground.push.usecase;

import com.quid.kafkaground.push.domain.PushMessage;
import com.quid.kafkaground.push.gateway.event.producer.PushProducer;
import com.quid.kafkaground.push.gateway.controller.dto.PushMessageReq;
import com.quid.kafkaground.push.gateway.repository.PushRepository;
import com.quid.kafkaground.push.gateway.repository.entity.PushMessageEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

public interface MessagePush {

    void push(PushMessageReq message);

    @Slf4j
    @Service
    @RequiredArgsConstructor
    class PushServiceImpl implements MessagePush {

        private final PushProducer pushProducer;
        private final PushRepository pushRepository;


        @Override
        public void push(PushMessageReq message) {
            List<PushMessage> pushMessages = message.toDomainList();
            pushRepository.saveAll(pushMessages);
            pushProducer.push(pushMessages);
            log.info("Pushed message: {}", pushMessages);
        }

    }
}
