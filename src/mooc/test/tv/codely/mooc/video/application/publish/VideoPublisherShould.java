package tv.codely.mooc.video.application.publish;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.video.domain.*;
import tv.codely.shared.domain.EventBus;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

final class VideoPublisherShould {
    @Test
    void publish_the_video_published_domain_event() {
        final EventBus eventBus = mock(EventBus.class);
        final VideoRepository videoRepository = mock(VideoRepository.class);
        final var videoPublisher = new VideoPublisher(eventBus, videoRepository);

        final var videoTitle = "\uD83C\uDF89 New YouTube.com/CodelyTV video title";
        final var videoDescription = "This should be the video description \uD83D\uDE42";

        videoPublisher.publish(videoTitle, videoDescription);

        final var expectedVideoCreated = new VideoPublished(videoTitle, videoDescription);
        final var expectedVideoSaved = Video.publish(new VideoTitle(videoTitle), new VideoDescription(videoDescription));

        verify(eventBus).publish(List.of(expectedVideoCreated));
        verify(videoRepository).save(expectedVideoSaved);
    }

}
