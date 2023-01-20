# Kafka

# kafka란?

Apache Kafka는 분산 스트리밍 플랫폼이다.   
메시지를 큐에 저장하고, 큐에 저장된 메시지를 읽어오는 기능을 제공한다.    
메시지를 큐에 저장하는 것을 publish, 큐에 저장된 메시지를 읽어오는 것을 subscribe라고 한다.    
Kafka는 publish/subscribe 메시지 큐이다.

# kafka의 특징

- 분산 스트리밍 플랫폼
- 메시지를 큐에 저장하고, 큐에 저장된 메시지를 읽어오는 기능을 제공한다.
- 메시지를 큐에 저장하는 것을 publish, 큐에 저장된 메시지를 읽어오는 것을 subscribe라고 한다.

## Producer

Producer는 메시지를 생성하는 역할을 한다.    
Producer는 메시지를 생성하고, 메시지를 큐에 저장한다.    
메시지를 큐에 저장하는 것을 publish라고 한다.

## Consumer

Consumer는 큐에 저장된 메시지를 읽어오는 역할을 한다.

## Topic

Topic은 메시지를 저장하는 큐이다.

## Partition

Partition은 Topic을 분할한 것이다.

## Broker

Broker는 Kafka를 구성하는 서버이다.


