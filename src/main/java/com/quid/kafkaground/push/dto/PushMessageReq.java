package com.quid.kafkaground.push.dto;

import com.quid.kafkaground.push.PushMessage;

public record PushMessageReq(String message, String sender, String receiver) {
    public PushMessage toEntity() {
        return PushMessage.builder()
            .message(message)
            .sender(sender)
            .receiver(receiver)
            .build();
    }
}
