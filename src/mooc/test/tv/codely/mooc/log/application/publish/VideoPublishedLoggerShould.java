package tv.codely.mooc.log.application.publish;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.log.LogModuleUnitTest;
import tv.codely.mooc.log.domain.LogAction;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoMother;

class VideoPublishedLoggerShould extends LogModuleUnitTest {

    private tv.codely.mooc.log.application.publish.VideoPublishedLogger videoPublishedLogger;

    @BeforeEach
    public void setUp() {
        videoPublishedLogger = new tv.codely.mooc.log.application.publish.VideoPublishedLogger(logger());
    }

    @Test
    public void log_video_published() {
        final Video video = VideoMother.random();

        videoPublishedLogger.log(video.title(), video.description());

        var logAction = new LogAction("published");

        shouldLog(video, logAction);
    }
}