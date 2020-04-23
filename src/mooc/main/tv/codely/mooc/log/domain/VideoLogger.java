package tv.codely.mooc.log.domain;

import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoDescription;
import tv.codely.mooc.video.domain.VideoTitle;

public interface VideoLogger {
    void log(Video video, LogAction action);
}
