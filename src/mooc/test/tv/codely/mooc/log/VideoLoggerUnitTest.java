package tv.codely.mooc.log;

import org.mockito.ArgumentCaptor;
import tv.codely.mooc.log.domain.LogAction;
import tv.codely.mooc.log.domain.LogVideo;
import tv.codely.mooc.log.domain.VideoLogger;
import tv.codely.shared.application.DomainEventSubscriber;
import tv.codely.shared.domain.DomainEvent;
import tv.codely.shared.infrastructure.UnitTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public abstract class VideoLoggerUnitTest extends UnitTest {

    private VideoLogger logger;

    protected VideoLogger logger() {
        if (logger == null) {
            logger = mock(VideoLogger.class);
        }
        return logger;
    }

    protected void shouldLog(LogVideo video, LogAction logAction) {
        ArgumentCaptor<LogVideo> videoCaptor = ArgumentCaptor.forClass(LogVideo.class);
        verify(logger()).log(videoCaptor.capture(), refEq(logAction));
        assertThat(videoCaptor.getValue()).usingRecursiveComparison()
                .isEqualTo(video);
    }
}
