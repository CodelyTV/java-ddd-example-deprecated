package tv.codely.context.video.module.video.infrastructure;

import tv.codely.context.notification.module.push.application.send.SendPushToSubscribersOnVideoPublished;
import tv.codely.context.video.module.video.application.publish.VideoPublisher;
import tv.codely.context.video.module.video.domain.VideoDescription;
import tv.codely.context.video.module.video.domain.VideoTitle;
import tv.codely.shared.application.DomainEventSubscriber;
import tv.codely.shared.domain.EventBus;
import tv.codely.shared.domain.video.VideoId;
import tv.codely.shared.infrastructure.bus.ReactorEventBus;

import java.util.Set;
import java.util.UUID;

public class VideoPublisherCliController {
    public static void main(String[] args) {
        // # App bootstrap

        // ## Bounded Context deps

        final Set<DomainEventSubscriber> subscribers = Set.of(
            new SendPushToSubscribersOnVideoPublished()
        );

        final EventBus eventBus = new ReactorEventBus(subscribers);


        // ### Subdomain deps

        final var videoPublisher = new VideoPublisher(eventBus);

        // # Controller

        final var rawId = UUID.randomUUID();
        final var rawTitle = "\uD83C\uDF89 New YouTube.com/CodelyTV video title";
        final var rawDescription = "This should be the video description \uD83D\uDE42";

        final var id = new VideoId(rawId);
        final var title = new VideoTitle(rawTitle);
        final var description = new VideoDescription(rawDescription);

        videoPublisher.publish(id, title, description);
    }
}
