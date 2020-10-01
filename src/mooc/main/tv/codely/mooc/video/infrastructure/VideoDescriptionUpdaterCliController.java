package tv.codely.mooc.video.infrastructure;

import tv.codely.mooc.notification.application.update.SendPushToSubscribersOnVideoDescriptionUpdated;
import tv.codely.mooc.video.application.update.VideoDescriptionUpdater;
import tv.codely.shared.application.DomainEventSubscriber;
import tv.codely.shared.domain.EventBus;
import tv.codely.shared.infrastructure.bus.ReactorEventBus;

import java.util.Set;

public class VideoDescriptionUpdaterCliController {
    public static void main(String[] args) {
        final Set<DomainEventSubscriber> subscribers = Set.of(
            new SendPushToSubscribersOnVideoDescriptionUpdated()
        );
        final EventBus eventBus = new ReactorEventBus(subscribers);
        final var videoDescriptionUpdater = new VideoDescriptionUpdater(eventBus);

        final var videoTitle = "\uD83C\uDF89 New YouTube.com/CodelyTV video title";
        final var videoDescription = "This should be the new video description \uD83D\uDE42";

        videoDescriptionUpdater.update(videoTitle, videoDescription);
    }
}
