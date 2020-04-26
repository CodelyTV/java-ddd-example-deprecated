package tv.codely.mooc.log.application.publish;

import tv.codely.mooc.log.domain.LogVideoDescription;
import tv.codely.mooc.log.domain.LogVideoTitle;
import tv.codely.mooc.video.domain.VideoPublished;
import tv.codely.shared.application.DomainEventSubscriber;

public class LogVideoPublishedOnVideoPublished implements DomainEventSubscriber<VideoPublished> {
    private final VideoPublishedLogger videoPublishedLogger;

    public LogVideoPublishedOnVideoPublished(VideoPublishedLogger videoPublishedLogger) {
        this.videoPublishedLogger = videoPublishedLogger;
    }

    @Override
    public Class<VideoPublished> subscribedTo() {
        return VideoPublished.class;
    }

    @Override
    public void consume(VideoPublished event) {
        videoPublishedLogger.log(new LogVideoTitle(event.title()), new LogVideoDescription(event.description()));
    }
}
