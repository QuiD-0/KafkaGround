package com.quid.kafkaground.push.gateway.repository.entity;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.quid.kafkaground.push.domain.PushMessage;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@Table(indexes = {
    @Index(name = "IDX_PUSH_MESSAGE_SENT", columnList = "sender"),
})
@NoArgsConstructor(access = PROTECTED)
public class PushMessageEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String message;
    private String sender;
    private String receiver;
    private LocalDateTime regDate;
    private Boolean isPublished;

    private PushMessageEntity(String message, String sender, String receiver) {
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
        this.isPublished = false;
        this.regDate = LocalDateTime.now();
    }


    public static PushMessageEntity fromDomain(PushMessage pushMessage) {
        return new PushMessageEntity(pushMessage.getMessage(), pushMessage.getSender(), pushMessage.getReceiver());
    }

    public PushMessage toDomain() {
        return PushMessage.of(id, message, sender, receiver, regDate, isPublished);
    }
}
