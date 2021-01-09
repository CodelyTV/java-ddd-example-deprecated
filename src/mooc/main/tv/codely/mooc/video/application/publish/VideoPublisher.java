package tv.codely.mooc.video.application.publish;

import lombok.AllArgsConstructor;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoDescription;
import tv.codely.mooc.video.domain.VideoRepository;
import tv.codely.mooc.video.domain.VideoTitle;
import tv.codely.shared.domain.EventBus;

@AllArgsConstructor
public final class VideoPublisher {
    EventBus eventBus;
    VideoRepository videoRepository;

    public void publish(String rawTitle, String rawDescription) {
        final var title = new VideoTitle(rawTitle);
        final var description = new VideoDescription(rawDescription);

        final var video = Video.publish(title, description);

        videoRepository.save(video);
        eventBus.publish(video.pullDomainEvents());
    }
}
