package tv.codely;

import tv.codely.context.notification.module.push.application.create.SendPushToSubscribersOnVideoPublished;
import tv.codely.context.video.module.video.domain.VideoPublished;
import tv.codely.shared.application.DomainEventSubscriber;
import tv.codely.shared.domain.EventBus;
import tv.codely.shared.infrastructure.bus.ReactorEventBus;

import java.util.Set;

public class Starter {
    public static void main(String[] args) {
        final Set<DomainEventSubscriber> subscribers = Set.of(
            new SendPushToSubscribersOnVideoPublished()
        );

        final EventBus eventBus = new ReactorEventBus(subscribers);

        final var videoPublished = new VideoPublished(
            "\uD83C\uDF89 New youtube.com/CodelyTV video title",
            "This should be the video description \uD83D\uDE42"
        );

        eventBus.publish(videoPublished);
    }
}
