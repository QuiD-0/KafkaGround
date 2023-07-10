package com.quid.kafkaground.push.domain;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class PushMessage {

    private Long id;
    private String message;
    private String sender;
    private String receiver;
    private LocalDateTime regDate;
    private Boolean isPublished;

    private PushMessage(Long id, String message, String sender, String receiver, LocalDateTime regDate, Boolean isPublished) {
        this.id = id;
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
        this.isPublished = isPublished;
        this.regDate = regDate;
    }

    public static PushMessage of(Long id, String message, String sender, String receiver, LocalDateTime regDate, Boolean isPublished) {
        return new PushMessage(id, message, sender, receiver, regDate, isPublished);
    }

    public static PushMessage create(String message, String sender, String receiver) {
        return new PushMessage(null, message, sender, receiver, LocalDateTime.now(), false);
    }

    public void sent() {
        this.isPublished = true;
    }

}
