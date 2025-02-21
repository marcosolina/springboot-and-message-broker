package it.marco.messagebrokerpublisher.services.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import it.marco.messagebrokerpublisher.services.interfaces.IMessagePublisher;
import it.marco.messagebrokerpublisher.services.interfaces.IScheduledJob;

@Service
public class MyScheduledJobs implements IScheduledJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyScheduledJobs.class);

    private IMessagePublisher messagePublisher;

    public MyScheduledJobs(IMessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @Override
    @Scheduled(cron = "0 * * * * *") // every minute
    public void everyMinute() {
        LOGGER.debug("1 Minute is gone");
        this.messagePublisher.sendMessage("Hello 1 minute");
    }

}
