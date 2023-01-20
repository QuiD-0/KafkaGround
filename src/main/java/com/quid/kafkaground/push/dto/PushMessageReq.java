package com.quid.kafkaground.push.dto;

public record PushMessageReq(String message, String sender, String receiver) {

}
