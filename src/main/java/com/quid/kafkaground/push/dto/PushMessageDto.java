package com.quid.kafkaground.push.dto;

import lombok.Data;

public record PushMessageDto(String message, String sender, String receiver) {

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


}
