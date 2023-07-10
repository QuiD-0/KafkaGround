package com.quid.kafkaground.push.gateway.repository;


import com.quid.kafkaground.push.gateway.repository.entity.PushMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PushJpaRepository extends JpaRepository<PushMessageEntity, Long> {

}
