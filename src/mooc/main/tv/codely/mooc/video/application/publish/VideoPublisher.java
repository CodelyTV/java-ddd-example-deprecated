package tv.codely.mooc.video.application.publish;

import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoDescription;
import tv.codely.mooc.video.domain.VideoTitle;
import tv.codely.mooc.video.domain.port.VideoManagementPort;
import tv.codely.shared.domain.EventBus;

public final class VideoPublisher {
    private final EventBus eventBus;
    private final VideoManagementPort videoManagementPort;

    public VideoPublisher(EventBus eventBus, VideoManagementPort videoManagementPort) {
        this.eventBus = eventBus;
        this.videoManagementPort = videoManagementPort;
    }

    public void publish(String rawTitle, String rawDescription) {
        final var title = new VideoTitle(rawTitle);
        final var description = new VideoDescription(rawDescription);

        final var video = Video.publish(title, description);

        eventBus.publish(video.pullDomainEvents());

        videoManagementPort.publish(video);
    }
}
