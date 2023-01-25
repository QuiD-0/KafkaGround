package com.quid.kafkaground.producer;

import com.quid.kafkaground.push.PushMessage;
import com.quid.kafkaground.push.dto.PushMessageDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PushProducer {

    private static final String PUSH = "push";
    private final KafkaTemplate<String, PushMessageDto> kafkaTemplate;

    public void push(List<PushMessage> message) {
        message.stream()
            .map(PushMessage::toDto)
            .forEach(this::send);
    }

    private void send(PushMessageDto m) {
        kafkaTemplate.send(PUSH, m);
    }
}
