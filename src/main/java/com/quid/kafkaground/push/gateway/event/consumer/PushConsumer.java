package com.quid.kafkaground.push.gateway.event.consumer;

import com.quid.kafkaground.push.gateway.controller.dto.PushMessageDto;
import com.quid.kafkaground.push.usecase.PublishDone;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PushConsumer {

    private final static String PUSH = "push";
    private final PublishDone publishDone;

    @KafkaListener(topics = PUSH, groupId = "push-group")
    public void consume(PushMessageDto message, Acknowledgment acknowledgment) {
        log.info("Consumed message: {}", message);
        publishDone.execute(message);
        acknowledgment.acknowledge();
    }
}