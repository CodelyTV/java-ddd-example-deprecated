package tv.codely.context.video.module.video.application.publish;

import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.Logger;
import tv.codely.context.video.module.video.domain.*;
import tv.codely.shared.domain.EventBus;
import tv.codely.shared.domain.video.VideoId;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

final class VideoPublisherShould {
    @Test
    void publish_the_video_published_domain_event() {
        final EventBus eventBus = mock(EventBus.class);
        final VideoRepository repository = mock(VideoRepository.class);
        final Logger logger = mock(Logger.class);
        final var videoPublisher = new VideoPublisher(logger, eventBus, repository);

        final var videoId = new VideoId(UUID.randomUUID());
        final var videoTitle = new VideoTitle("\uD83C\uDF89 New YouTube.com/CodelyTV video title");
        final var videoDescription = new VideoDescription("This should be the video description \uD83D\uDE42");

        videoPublisher.publish(videoId, videoTitle, videoDescription);

        final var expectedVideoCreated = new VideoPublished(
            videoId.value(),
            videoTitle.value(),
            videoDescription.value()
        );

//        final var video = new Video(videoId, videoTitle, videoDescription);

//        verify(repository).save(video);
        verify(eventBus).publish(List.of(expectedVideoCreated));
    }

}
