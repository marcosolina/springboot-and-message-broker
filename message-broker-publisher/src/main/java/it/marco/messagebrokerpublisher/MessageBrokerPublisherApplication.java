package it.marco.messagebrokerpublisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MessageBrokerPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageBrokerPublisherApplication.class, args);
	}

}
