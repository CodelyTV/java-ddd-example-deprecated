package tv.codely.mooc.video.application.publish;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoDescription;
import tv.codely.mooc.video.domain.VideoRepository;
import tv.codely.mooc.video.domain.VideoTitle;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

final class VideoLastPublishedFinderShould {
    @Test
    void get_last_video_published() {
        final VideoRepository videoRepository = mock(VideoRepository.class);
        final var finder = new VideoLastPublishedFinder(videoRepository);
        final var exampleVideo = Video.publish(new VideoTitle("t"), new VideoDescription("t"));
        doReturn(Optional.of(exampleVideo)).when(videoRepository).getLastVideo();

        Optional<Video> lastVideoPublishedOpt = finder.getLastVideoPublished();

        assertEquals(exampleVideo, lastVideoPublishedOpt.get());
    }

}
