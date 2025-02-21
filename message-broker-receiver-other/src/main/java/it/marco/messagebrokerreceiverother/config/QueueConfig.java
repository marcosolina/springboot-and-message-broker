package it.marco.messagebrokerreceiverother.config;

import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.marco.messagebrokerreceiverother.services.implementations.MyMessageReceiverQueueOne;
import it.marco.messagebrokerreceiverother.services.implementations.MyMessageReceiverQueueTwo;
import it.marco.messagebrokerreceiverother.services.interfaces.IMessageReceiver;

@Configuration
public class QueueConfig {
    
    public static final String QUEUE_ONE = "my-queue-1";
    public static final String QUEUE_TWO = "my-queue-2";

    @Bean
    SimpleMessageListenerContainer queueOneListener(ConnectionFactory connectionFactory, MyMessageReceiverQueueOne receiver) {
        return createListenerContainer(connectionFactory, QUEUE_ONE, receiver);
    }
    
    @Bean
    SimpleMessageListenerContainer queueTwoListener(ConnectionFactory connectionFactory, MyMessageReceiverQueueTwo receiver) {
        return createListenerContainer(connectionFactory, QUEUE_TWO, receiver);
    }

    private SimpleMessageListenerContainer createListenerContainer(
            ConnectionFactory connectionFactory, 
            String queueName, 
            IMessageReceiver receiver) {
        
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener((MessageListener) message -> {
            String body = new String(message.getBody());
            receiver.receiveMessage(body);
        });

        return container;
    }
    
}
