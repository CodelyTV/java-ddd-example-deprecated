package tv.codely.mooc.notification.application.create;

import lombok.AllArgsConstructor;
import tv.codely.mooc.errors.domain.ErrorGenerated;
import tv.codely.mooc.notification.domain.TwitterException;
import tv.codely.mooc.notification.domain.TwitterPublisher;
import tv.codely.mooc.video.domain.VideoPublished;
import tv.codely.shared.application.DomainEventSubscriber;
import tv.codely.shared.domain.EventBus;

import static java.util.Arrays.asList;

@AllArgsConstructor
public class SendTweetOnVideoPublished implements DomainEventSubscriber<VideoPublished> {

    TwitterPublisher publisher;
    EventBus eventBus;

    @Override
    public Class<VideoPublished> subscribedTo() {
        return VideoPublished.class;
    }

    @Override
    public void consume(VideoPublished event) {
        try {
            publisher.tweet("New video published: " + event.title());
        } catch (TwitterException e) {
            eventBus.publish(asList(new ErrorGenerated("Error tweeting after video published", e)));
        }
    }
}
