package com.quid.kafkaground.producer;

import com.quid.kafkaground.push.dto.PushMessageReq;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PushProducer {

    private static final String PUSH = "push";
    private final KafkaTemplate<String, PushMessageReq> kafkaTemplate;

    public void push(PushMessageReq message) {
        kafkaTemplate.send(PUSH,"pushKey", message);
    }

}
