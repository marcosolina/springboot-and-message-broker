package it.marco.messagebrokerreceiverother;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MessageBrokerReceiverOtherApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageBrokerReceiverOtherApplication.class, args);
	}

}
