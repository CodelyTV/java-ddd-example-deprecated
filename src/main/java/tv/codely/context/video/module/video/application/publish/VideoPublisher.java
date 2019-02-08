package tv.codely.context.video.module.video.application.publish;

import tv.codely.context.video.module.video.domain.Video;
import tv.codely.context.video.module.video.domain.VideoDescription;
import tv.codely.context.video.module.video.domain.VideoTitle;
import tv.codely.shared.domain.EventBus;
import tv.codely.shared.domain.video.VideoId;

public final class VideoPublisher {
    private final EventBus eventBus;

    public VideoPublisher(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void publish(VideoId id, VideoTitle title, VideoDescription description) {
        final var video = Video.publish(id, title, description);

        eventBus.publish(video.pullDomainEvents());
    }
}
