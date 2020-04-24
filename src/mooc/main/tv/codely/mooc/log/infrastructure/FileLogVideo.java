package tv.codely.mooc.log.infrastructure;

import tv.codely.mooc.log.domain.LogAction;
import tv.codely.mooc.log.domain.LogVideo;

public class FileLogVideo {
    private final LoggedVideo video;
    private final String action;

    public FileLogVideo(LoggedVideo video, String action) {
        this.video = video;
        this.action = action;
    }

    public static FileLogVideo create(LogVideo logVideo, LogAction logAction) {
        return new FileLogVideo(
                new LoggedVideo(logVideo.title().value(), logVideo.description().value()),
                VideoAction.finalValueOf(logAction.value())
        );
    }
}
