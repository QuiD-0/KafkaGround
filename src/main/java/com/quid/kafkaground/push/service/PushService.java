package com.quid.kafkaground.push.service;

import com.quid.kafkaground.push.dto.PushMessageDto;
import com.quid.kafkaground.push.dto.PushMessageReq;

public interface PushService {
    void push(PushMessageReq message);

    void updateSent(PushMessageDto message);
}
