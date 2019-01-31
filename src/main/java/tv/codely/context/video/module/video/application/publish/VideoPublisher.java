package tv.codely.context.video.module.video.application.publish;

import tv.codely.context.video.module.video.domain.Video;
import tv.codely.context.video.module.video.domain.VideoDescription;
import tv.codely.context.video.module.video.domain.VideoId;
import tv.codely.context.video.module.video.domain.VideoTitle;
import tv.codely.shared.domain.EventBus;

public final class VideoPublisher {
    private final EventBus eventBus;

    public VideoPublisher(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void publish(String rawId, String rawTitle, String rawDescription) {
        final var id = new VideoId(rawId);
        final var title = new VideoTitle(rawTitle);
        final var description = new VideoDescription(rawDescription);

        final var video = Video.publish(id, title, description);

        eventBus.publish(video.pullDomainEvents());
    }
}
