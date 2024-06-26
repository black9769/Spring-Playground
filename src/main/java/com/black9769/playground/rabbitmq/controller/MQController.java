package com.black9769.playground.rabbitmq.controller;

import com.black9769.playground.rabbitmq.repo.dto.MQDTO;
import com.black9769.playground.rabbitmq.service.MQService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MQController {
    private final MQService mqService;

    /**
     * Queue로 메시지를 발행
     *
     * @param messageDto 발행할 메시지의 DTO 객체
     * @return ResponseEntity 객체로 응답을 반환
     */
    @RequestMapping(value = "/send/message", method = RequestMethod.POST)
    public ResponseEntity<?> sendMessage(@RequestBody MQDTO messageDto) {
        mqService.sendMessages(messageDto);
        return ResponseEntity.ok("Message sent to RabbitMQ!");
    }

}
