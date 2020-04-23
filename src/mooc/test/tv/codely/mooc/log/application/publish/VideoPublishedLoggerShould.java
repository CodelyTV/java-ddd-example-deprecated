package tv.codely.mooc.log.application.publish;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.log.LogModuleUnitTest;
import tv.codely.mooc.log.domain.LogAction;
import tv.codely.mooc.log.domain.LogVideoMother;

class VideoPublishedLoggerShould extends LogModuleUnitTest {

    private VideoPublishedLogger videoPublishedLogger;

    @BeforeEach
    public void setUp() {
        videoPublishedLogger = new VideoPublishedLogger(logger());
    }

    @Test
    public void log_video_published() {
        final var video = LogVideoMother.random();

        videoPublishedLogger.log(video.title(), video.description());

        var logAction = new LogAction("published");
        shouldLog(video, logAction);
    }
}