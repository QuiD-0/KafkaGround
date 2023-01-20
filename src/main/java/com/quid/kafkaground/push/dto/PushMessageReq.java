package com.quid.kafkaground.push.dto;

import com.quid.kafkaground.push.PushMessage;
import java.util.List;

public record PushMessageReq(String message, String sender, List<String> receiver) {

    public List<PushMessage> toEntityList() {
        return receiver.stream().map(id -> PushMessage.builder()
            .message(message)
            .sender(sender)
            .receiver(id)
            .build())
            .toList();
    }
}
