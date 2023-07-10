package com.quid.kafkaground.push.gateway.controller.dto;

import com.quid.kafkaground.push.domain.PushMessage;
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

    public List<PushMessage> toDomainList() {
        return receiver.stream()
            .map(this::toDomain)
            .toList();
    }

    private PushMessage toDomain(String id) {
        return PushMessage.create(message, sender, id);
    }
}
