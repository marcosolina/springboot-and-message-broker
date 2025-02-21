package it.marco.messagebrokerreceiver.services.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.marco.messagebrokerreceiver.services.interfaces.IMessageReceiver;

@Service
public class MyMessageReceiver implements IMessageReceiver{
    private static final Logger LOGGER = LoggerFactory.getLogger(MyMessageReceiver.class);
    
    @Override
    public void receiveMessage(String message) {
        LOGGER.debug("Received a message on queue 1:");
        LOGGER.debug(message);
    }

}
