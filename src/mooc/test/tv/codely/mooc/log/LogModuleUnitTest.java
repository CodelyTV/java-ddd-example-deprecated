package tv.codely.mooc.log;

import tv.codely.mooc.log.domain.LogAction;
import tv.codely.mooc.log.domain.VideoLogger;
import tv.codely.mooc.video.domain.Video;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public abstract class LogModuleUnitTest {

    private VideoLogger logger;

    protected VideoLogger logger() {
        if (logger == null) {
            logger = mock(VideoLogger.class);
        }
        return logger;
    }

    protected void shouldLog(Video video, LogAction logAction) {
        verify(logger()).log(refEq(video), refEq(logAction));
    }
}
