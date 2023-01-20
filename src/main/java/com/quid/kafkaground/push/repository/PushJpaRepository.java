package com.quid.kafkaground.push.repository;


import com.quid.kafkaground.push.PushMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PushJpaRepository extends JpaRepository<PushMessage, Long> {

}
