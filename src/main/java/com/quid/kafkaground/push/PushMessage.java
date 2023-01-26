package com.quid.kafkaground.push;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.quid.kafkaground.push.dto.PushMessageDto;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@ToString
@Table(indexes = {
    @Index(name = "IDX_PUSH_MESSAGE_SENT", columnList = "sender"),
})
@NoArgsConstructor(access = PROTECTED)
public class PushMessage {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String message;
    private String sender;
    private String receiver;
    private LocalDateTime regDate;
    private boolean sent;

    private PushMessage(String message, String sender, String receiver) {
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
        this.sent = false;
        this.regDate = LocalDateTime.now();
    }

    public static PushMessage of(String message, String sender, String receiver) {
        return new PushMessage(message, sender, receiver);
    }

    public PushMessageDto toDto() {
        return new PushMessageDto(id, message, sender, receiver);
    }

    public void sent() {
        this.sent = true;
    }
}
