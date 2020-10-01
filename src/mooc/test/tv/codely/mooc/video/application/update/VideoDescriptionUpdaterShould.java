package tv.codely.mooc.video.application.update;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.video.domain.VideoDescriptionUpdated;
import tv.codely.shared.domain.EventBus;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

final class VideoDescriptionUpdaterShould {
    @Test
    void publish_the_video_description_updated_domain_event() {
        final EventBus eventBus = mock(EventBus.class);
        final var videoDescriptionUpdater = new VideoDescriptionUpdater(eventBus);

        final var videoTitle = "\uD83C\uDF89 New YouTube.com/CodelyTV video title";
        final var videoDescription = "This should be the video description \uD83D\uDE42";

        videoDescriptionUpdater.update(videoTitle, videoDescription);

        final var expectedVideoDescriptionUpdated = new VideoDescriptionUpdated(videoTitle, videoDescription);

        verify(eventBus).publish(List.of(expectedVideoDescriptionUpdated));
    }

}
