package it.marco.messagebrokerpublisher.services.implementations;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import it.marco.messagebrokerpublisher.config.QueueConfig;
import it.marco.messagebrokerpublisher.services.interfaces.IMessagePublisher;

@Service
public class RabbitMqPublisher implements IMessagePublisher {
    private RabbitTemplate rabbitTemplate;

    public RabbitMqPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(String routingKey, String message) {
        this.rabbitTemplate.convertAndSend(QueueConfig.TOPIC, routingKey, message);
        
    }
}
