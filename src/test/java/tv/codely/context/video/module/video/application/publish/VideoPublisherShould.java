package tv.codely.context.video.module.video.application.publish;

import org.junit.jupiter.api.Test;
import tv.codely.context.video.module.video.domain.VideoPublished;
import tv.codely.shared.domain.EventBus;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

final class VideoPublisherShould {
    @Test
    void publish_the_video_published_domain_event() {
        final EventBus eventBus = mock(EventBus.class);
        final var videoPublisher = new VideoPublisher(eventBus);

        final var videoId = UUID.randomUUID().toString();
        final var videoTitle = "\uD83C\uDF89 New YouTube.com/CodelyTV video title";
        final var videoDescription = "This should be the video description \uD83D\uDE42";

        videoPublisher.publish(videoId, videoTitle, videoDescription);

        final var expectedVideoCreated = new VideoPublished(videoId, videoTitle, videoDescription);

        verify(eventBus).publish(List.of(expectedVideoCreated));
    }

}
