package com.quid.kafkaground.push.repository;

import com.quid.kafkaground.push.PushMessage;
import java.util.List;

public interface PushRepository {

    void updateSent(Long id);
    void saveAll(List<PushMessage> pushMessages);
}
