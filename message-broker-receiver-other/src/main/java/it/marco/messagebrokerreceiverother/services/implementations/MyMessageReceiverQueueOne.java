package it.marco.messagebrokerreceiverother.services.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.marco.messagebrokerreceiverother.services.interfaces.IMessageReceiver;

@Service
public class MyMessageReceiverQueueOne implements IMessageReceiver{
    private static final Logger LOGGER = LoggerFactory.getLogger(MyMessageReceiverQueueOne.class);
    
    @Override
    public void receiveMessage(String message) {
        LOGGER.debug("Received a message on queue 1:");
        LOGGER.debug(message);
    }

}
