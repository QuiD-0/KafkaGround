package com.quid.kafkaground.push.usecase;

import com.quid.kafkaground.push.gateway.controller.dto.PushMessageDto;
import com.quid.kafkaground.push.gateway.repository.PushRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface PublishDone {
    void execute(PushMessageDto message);

    @Service
    @RequiredArgsConstructor
    class UpdateSentImpl implements PublishDone {

        private final PushRepository pushRepository;

        @Override
        @Transactional
        public void execute(PushMessageDto message) {
            pushRepository.updateSent(message.id());
        }
    }

}
