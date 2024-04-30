package com.black9769.playground.rabbitmq.service;

import com.black9769.playground.rabbitmq.repo.dto.MQDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MQService {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendMessages(MQDTO message) {
        log.info("Message sent: {}", message.toString());
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void receiveMessages(MQDTO message) {
        log.info("Message received: {}", message.toString());
    }
}
