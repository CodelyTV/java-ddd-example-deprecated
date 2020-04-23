package tv.codely.mooc.log.application.publish;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.log.domain.LogAction;
import tv.codely.mooc.log.domain.VideoLogger;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoDescription;
import tv.codely.mooc.video.domain.VideoTitle;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class VideoPublishedLoggerShould {

    private tv.codely.mooc.log.application.publish.VideoPublishedLogger videoPublishedLogger;
    private VideoLogger logger;

    @BeforeEach
    public void setUp() {
        logger = mock(VideoLogger.class);
        videoPublishedLogger = new tv.codely.mooc.log.application.publish.VideoPublishedLogger(logger);
    }

    @Test
    public void log_video_published() {
        var title = new VideoTitle("\uD83C\uDF89 New YouTube.com/CodelyTV video title");
        var description = new VideoDescription("This should be the video description \uD83D\uDE42");
        final Video video = Video.build(title, description);

        videoPublishedLogger.log(video.title(), video.description());

        var logAction = new LogAction("published");

        verify(logger).log(refEq(video), refEq(logAction));
    }
}