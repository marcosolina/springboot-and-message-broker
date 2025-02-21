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
        this.messagePublisher.sendMessage("foo.bar.some.test.on.queue.one", "Hello 1 minute for queue 1");
        this.messagePublisher.sendMessage("foo.baz.onqueuetwo", "Hello 1 minute for queue 2");
        this.messagePublisher.sendMessage("foo.not.routed", "Hello 1 minute");
    }

    @Override
    @Scheduled(cron = "0 */2 * * * *") // every minute
    public void everyTwoMinutes() {
        LOGGER.debug("2 Minutes are gone");
        this.messagePublisher.sendMessage("foo.baz.onqueuetwo", "Hello 2 minute for queue 2");
    }

}
