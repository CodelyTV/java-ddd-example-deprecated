package tv.codely.context.video.module.video.application.create;

import tv.codely.context.video.module.video.domain.Video;
import tv.codely.shared.domain.EventBus;

public final class VideoPublisher {
    private final EventBus eventBus;

    public VideoPublisher(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void publish(String title, String description) {
        final var video = Video.publish(title, description);

        eventBus.publish(video.pullDomainEvents());
    }

}
