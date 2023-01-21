package com.quid.kafkaground.push.dto;

import com.quid.kafkaground.push.PushMessage;
import java.util.List;

public record PushMessageReq(String message, String sender, List<String> receiver) {

    public PushMessageReq {
        if (receiver == null || receiver.isEmpty()) {
            throw new IllegalArgumentException("receiver is empty");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("message is empty");
        }
        if (sender == null || sender.isBlank()) {
            throw new IllegalArgumentException("sender is empty");
        }
    }

    public List<PushMessage> toEntityList() {
        return receiver.stream()
            .map(this::toEntity)
            .toList();
    }

    private PushMessage toEntity(String id) {
        return PushMessage.of(message, sender, id);
    }
}
