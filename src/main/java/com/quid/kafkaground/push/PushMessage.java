package com.quid.kafkaground.push;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.quid.kafkaground.push.dto.PushMessageDto;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@ToString
@Table(name = "PUSH_MESSAGE")
@NoArgsConstructor(access = PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class PushMessage {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String message;
    private String sender;
    private String receiver;
    @CreatedDate
    private LocalDateTime regDate;
    private boolean sent;

    private PushMessage(String message, String sender, String receiver) {
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
        this.sent = false;
    }

    public static PushMessage of(String message, String sender, String receiver) {
        return new PushMessage(message, sender, receiver);
    }

    public PushMessageDto toDto() {
        return new PushMessageDto(id,message, sender, receiver);
    }

    public void sent() {
        this.sent = true;
    }
}
