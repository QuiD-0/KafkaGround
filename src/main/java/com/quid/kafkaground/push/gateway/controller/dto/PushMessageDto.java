package com.quid.kafkaground.push.gateway.controller.dto;

import com.quid.kafkaground.push.domain.PushMessage;
import lombok.Data;

public record PushMessageDto(Long id, String message, String sender, String receiver) {

    public PushMessageDto {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
        if (sender == null || sender.isBlank()) {
            throw new IllegalArgumentException("Sender cannot be empty");
        }
        if (receiver == null || receiver.isBlank()) {
            throw new IllegalArgumentException("Receiver cannot be empty");
        }
    }


    public static PushMessageDto fromDomain(PushMessage pushMessage) {
        return new PushMessageDto(pushMessage.getId(), pushMessage.getMessage(), pushMessage.getSender(), pushMessage.getReceiver());
    }
}
