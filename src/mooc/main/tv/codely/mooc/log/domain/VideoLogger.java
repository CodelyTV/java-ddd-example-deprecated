package tv.codely.mooc.log.domain;

import tv.codely.mooc.video.domain.Video;

public interface VideoLogger {
    void log(Video video, LogAction action);
}
