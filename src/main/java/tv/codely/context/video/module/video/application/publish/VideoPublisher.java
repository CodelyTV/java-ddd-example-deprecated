package tv.codely.context.video.module.video.application.publish;

import tv.codely.context.video.module.video.domain.Video;
import tv.codely.context.video.module.video.domain.VideoDescription;
import tv.codely.context.video.module.video.domain.VideoTitle;
import tv.codely.shared.domain.EventBus;

public final class VideoPublisher {
    private final EventBus eventBus;

    public VideoPublisher(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void publish(String rawTitle, String rawDescription) {
        final var title = new VideoTitle(rawTitle);
        final var description = new VideoDescription(rawDescription);

        final var video = Video.publish(title, description);

        eventBus.publish(video.pullDomainEvents());
    }
}
