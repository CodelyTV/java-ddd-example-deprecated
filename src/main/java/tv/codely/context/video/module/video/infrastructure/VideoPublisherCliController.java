package tv.codely.context.video.module.video.infrastructure;

import tv.codely.context.notification.module.push.application.create.SendPushToSubscribersOnVideoPublished;
import tv.codely.context.video.module.video.application.publish.VideoPublisher;
import tv.codely.shared.application.DomainEventSubscriber;
import tv.codely.shared.domain.EventBus;
import tv.codely.shared.infrastructure.bus.ReactorEventBus;

import java.util.Set;
import java.util.UUID;

public class VideoPublisherCliController {
    public static void main(String[] args) {
        final Set<DomainEventSubscriber> subscribers = Set.of(
            new SendPushToSubscribersOnVideoPublished()
        );
        final EventBus eventBus = new ReactorEventBus(subscribers);
        final var videoPublisher = new VideoPublisher(eventBus);

        final var videoId = UUID.randomUUID().toString();
        final var videoTitle = "\uD83C\uDF89 New YouTube.com/CodelyTV video title";
        final var videoDescription = "This should be the video description \uD83D\uDE42";

        videoPublisher.publish(videoId, videoTitle, videoDescription);
    }
}
