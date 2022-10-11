package tv.codely.mooc.video.application.publish;

import java.time.Instant;
import tv.codely.mooc.video.domain.ServiceAPI;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoDescription;
import tv.codely.mooc.video.domain.VideoTitle;
import tv.codely.shared.domain.EventBus;

public final class VideoPublisher {
    private final EventBus eventBus;
    private ServiceAPI serviceAPI;

    public VideoPublisher(EventBus eventBus, ServiceAPI serviceAPI) {
        this.eventBus = eventBus;
        this.serviceAPI = serviceAPI;
    }

    public void publish(String rawTitle, String rawDescription) {
        final var title = new VideoTitle(rawTitle);
        final var description = new VideoDescription(rawDescription);

        final var video = Video.publish(title, description);

        eventBus.publish(video.pullDomainEvents());
        serviceAPI.create();
    }
}
