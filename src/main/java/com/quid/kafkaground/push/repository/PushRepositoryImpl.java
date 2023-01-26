package com.quid.kafkaground.push.repository;

import com.quid.kafkaground.push.PushMessage;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PushRepositoryImpl implements PushRepository {

    private final PushJpaRepository pushJpaRepository;

    @Override
    public void updateSent(Long id) {
        pushJpaRepository.findById(id).ifPresent(PushMessage::sent);
    }

    @Override
    public void saveAll(List<PushMessage> pushMessages) {
        pushJpaRepository.saveAll(pushMessages);
    }
}
