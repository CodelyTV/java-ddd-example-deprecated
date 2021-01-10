package tv.codely.mooc.video.infrastructure;

import tv.codely.mooc.notification.application.create.SendPushToSubscribersOnVideoPublished;
import tv.codely.mooc.notification.application.create.SendTweetOnVideoPublished;
import tv.codely.mooc.notification.domain.TwitterPublisher;
import tv.codely.mooc.notification.infrastructure.FakeTwitterPublisher;
import tv.codely.mooc.video.application.publish.VideoPublisher;
import tv.codely.shared.application.DomainEventSubscriber;
import tv.codely.shared.domain.EventBus;
import tv.codely.shared.infrastructure.bus.ReactorEventBus;

import java.util.Set;

public class VideoPublisherCliController {
    public static void main(String[] args) {
        final TwitterPublisher twitterPublisher = new FakeTwitterPublisher();
        final Set<DomainEventSubscriber> subscribers = Set.of(
            new SendPushToSubscribersOnVideoPublished(),
            new SendTweetOnVideoPublished(twitterPublisher)
        );
        final EventBus eventBus = new ReactorEventBus(subscribers);
        final var videoPublisher = new VideoPublisher(eventBus);

        final var videoTitle = "\uD83C\uDF89 New YouTube.com/CodelyTV video title";
        final var videoDescription = "This should be the video description \uD83D\uDE42";

        videoPublisher.publish(videoTitle, videoDescription);
    }
}
