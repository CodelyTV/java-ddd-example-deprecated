package tv.codely.mooc.video.application.update;

import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoDescription;
import tv.codely.mooc.video.domain.VideoTitle;
import tv.codely.shared.domain.EventBus;

public final class VideoDescriptionUpdater {
    private final EventBus eventBus;

    public VideoDescriptionUpdater(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void update(String rawTitle, String rawDescription) {
        final var title = new VideoTitle(rawTitle);
        final var description = new VideoDescription(rawDescription);

        final var video = Video.updateDescription(title, description);

        eventBus.publish(video.pullDomainEvents());
    }
}
