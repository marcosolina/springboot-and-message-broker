package it.marco.messagebrokerpublisher.services.interfaces;

public interface IMessagePublisher {
    public void sendMessage(String routingKey, String message);
}
