package it.marco.messagebrokerreceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MessageBrokerReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageBrokerReceiverApplication.class, args);
	}

}
