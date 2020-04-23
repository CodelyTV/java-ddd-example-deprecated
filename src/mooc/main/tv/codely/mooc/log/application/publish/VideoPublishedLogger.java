package tv.codely.mooc.log.application.publish;

import tv.codely.mooc.log.domain.*;

public class VideoPublishedLogger {

    private final VideoLogger logger;

    public VideoPublishedLogger(VideoLogger logger) {

        this.logger = logger;
    }

    public void log(LogVideoTitle title, LogVideoDescription description) {
        final var video = new LogVideo(title, description);
        logger.log(video, new LogAction("published"));
    }
}
