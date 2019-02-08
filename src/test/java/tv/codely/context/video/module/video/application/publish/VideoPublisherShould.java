package tv.codely.context.video.module.video.application.publish;

import org.junit.jupiter.api.Test;
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
        final var videoPublisher = new VideoPublisher(eventBus);

        final var videoId = new VideoId(UUID.randomUUID());
        final var videoTitle = new VideoTitle("\uD83C\uDF89 New YouTube.com/CodelyTV video title");
        final var videoDescription = new VideoDescription("This should be the video description \uD83D\uDE42");

        videoPublisher.publish(videoId, videoTitle, videoDescription);

        final var expectedVideoCreated = new VideoPublished(
            videoId.value(),
            videoTitle.value(),
            videoDescription.value()
        );

        verify(eventBus).publish(List.of(expectedVideoCreated));
    }

}
