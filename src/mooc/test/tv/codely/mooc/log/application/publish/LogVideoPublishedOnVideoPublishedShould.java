package tv.codely.mooc.log.application.publish;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.log.VideoLoggerUnitTest;
import tv.codely.mooc.log.domain.LogAction;
import tv.codely.mooc.log.domain.LogVideoMother;
import tv.codely.mooc.video.domain.VideoMother;
import tv.codely.mooc.video.domain.VideoPublished;

class LogVideoPublishedOnVideoPublishedShould extends VideoLoggerUnitTest {

    private LogVideoPublishedOnVideoPublished logVideoPublishedOnVideoPublished;

    @BeforeEach
    void setUp() {
        logVideoPublishedOnVideoPublished = new LogVideoPublishedOnVideoPublished(new VideoPublishedLogger(logger()));
    }

    @Test
    public void log_the_published_video() {
        final var video = VideoMother.random();
        final var videoPublishedEvent = new VideoPublished(video.title().value(), video.description().value());

        logVideoPublishedOnVideoPublished.consume(videoPublishedEvent);

        final var logVideo = LogVideoMother.createFrom(video);
        final var logAction = new LogAction("published");
        shouldLog(logVideo, logAction);
    }
}