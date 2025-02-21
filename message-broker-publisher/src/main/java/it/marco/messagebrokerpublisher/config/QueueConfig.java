package it.marco.messagebrokerpublisher.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    public static final String TOPIC = "my-topic";

    public static final String QUEUE_ONE = "my-queue-1";
    public static final String QUEUE_TWO = "my-queue-2";

    public static final String ROUTING_KEY_ONE = "foo.bar.#";   // Matches anything starting with "foo.bar."
    public static final String ROUTING_KEY_TWO = "foo.baz.*";   // Matches exactly "foo.baz.something"

    
    private boolean theQueueShouldSurviceAServerRestart = false;
    

    @Bean
    Queue queueOne() {
        return new Queue(QUEUE_ONE, theQueueShouldSurviceAServerRestart);
    }
    
    @Bean
    Queue queueTwo() {
        return new Queue(QUEUE_TWO, theQueueShouldSurviceAServerRestart);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(TOPIC);
    }

    @Bean
    Binding bindingOne(Queue queueOne, TopicExchange exchange) {
        return BindingBuilder.bind(queueOne).to(exchange).with(ROUTING_KEY_ONE);
    }
    
    @Bean
    Binding bindingTwo(Queue queueTwo, TopicExchange exchange) {
        return BindingBuilder.bind(queueTwo).to(exchange).with(ROUTING_KEY_TWO);
    }
}
