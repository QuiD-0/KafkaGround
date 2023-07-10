package com.quid.kafkaground.push.gateway.repository;

import com.quid.kafkaground.push.domain.PushMessage;
import com.quid.kafkaground.push.gateway.repository.entity.PushMessageEntity;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

public interface PushRepository {

    void updateSent(Long id);
    void saveAll(List<PushMessage> pushMessages);

    @Repository
    @RequiredArgsConstructor
    class PushRepositoryImpl implements PushRepository {

        private final PushJpaRepository pushJpaRepository;

        @Override
        public void updateSent(Long id) {
            pushJpaRepository.findById(id)
                .map(PushMessageEntity::toDomain)
                .ifPresent(PushMessage::sent);
        }

        @Override
        public void saveAll(List<PushMessage> pushMessages) {
            List<PushMessageEntity> data = pushMessages.stream()
                .map(PushMessageEntity::fromDomain)
                .toList();
            pushJpaRepository.saveAll(data);
        }
    }

}
