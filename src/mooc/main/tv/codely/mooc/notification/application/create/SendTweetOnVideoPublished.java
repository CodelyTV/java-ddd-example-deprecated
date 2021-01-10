package tv.codely.mooc.notification.application.create;

import lombok.AllArgsConstructor;
import tv.codely.mooc.notification.domain.TwitterPublisher;
import tv.codely.mooc.video.domain.VideoPublished;
import tv.codely.shared.application.DomainEventSubscriber;

@AllArgsConstructor
public class SendTweetOnVideoPublished implements DomainEventSubscriber<VideoPublished> {

    TwitterPublisher publisher;

    @Override
    public Class<VideoPublished> subscribedTo() {
        return VideoPublished.class;
    }

    @Override
    public void consume(VideoPublished event) {
        publisher.tweet("New video published: " + event.title());
    }
}
