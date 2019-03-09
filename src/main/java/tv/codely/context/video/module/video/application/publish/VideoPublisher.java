package tv.codely.context.video.module.video.application.publish;

import org.apache.logging.log4j.Logger;
import tv.codely.context.video.module.video.domain.Video;
import tv.codely.context.video.module.video.domain.VideoDescription;
import tv.codely.context.video.module.video.domain.VideoRepository;
import tv.codely.context.video.module.video.domain.VideoTitle;
import tv.codely.shared.domain.EventBus;
import tv.codely.shared.domain.video.VideoId;

public final class VideoPublisher {
    private final Logger logger;
    private final EventBus eventBus;
    private final VideoRepository repository;

    public VideoPublisher(Logger logger, EventBus eventBus, VideoRepository repository) {
        this.logger = logger;
        this.eventBus = eventBus;
        this.repository = repository;
    }

    public void publish(VideoId id, VideoTitle title, VideoDescription description) {
        final var video = Video.publish(id, title, description);

//        RuntimeException error = new RuntimeException("exceptioooon");
//        logger.error("Hello error world!", error);
        logger.error("Hello error world!");

        // repository.save(video);
        eventBus.publish(video.pullDomainEvents());
    }
}
