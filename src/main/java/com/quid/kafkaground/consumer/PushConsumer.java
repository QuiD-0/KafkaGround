package com.quid.kafkaground.consumer;

import com.quid.kafkaground.push.dto.PushMessageDto;
import com.quid.kafkaground.push.repository.PushJpaRepository;
import com.quid.kafkaground.push.service.PushService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PushConsumer {

    private final static String PUSH = "push";
    private final PushService pushService;

    @Transactional
    @KafkaListener(topics = PUSH, groupId = "push-group")
    public void consume(PushMessageDto message) {
        log.info("Consumed message: {}", message);
        pushService.updateSent(message);
    }
}