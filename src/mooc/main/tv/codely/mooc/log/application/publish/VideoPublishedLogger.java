package tv.codely.mooc.log.application.publish;

import tv.codely.mooc.log.domain.LogAction;
import tv.codely.mooc.log.domain.VideoLogger;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoDescription;
import tv.codely.mooc.video.domain.VideoTitle;

public class VideoPublishedLogger {

    private final VideoLogger logger;

    public VideoPublishedLogger(VideoLogger logger) {

        this.logger = logger;
    }

    public void log(VideoTitle title, VideoDescription description) {
        final var video = Video.build(title, description);
        logger.log(video, new LogAction("published"));
    }
}
