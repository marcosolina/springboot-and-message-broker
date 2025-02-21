package it.marco.messagebrokerpublisher.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    public static final String topicExchangeName = "my-topic";

    public static final String queueName = "my-queue";
    
    public static final String routingKey = "foo.bar.#";
    
    @Bean
    Queue queue() {
      return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
      return new TopicExchange(topicExchangeName);
    }
    
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
      return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }
}
