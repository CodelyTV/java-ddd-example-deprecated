package tv.codely.mooc.log.domain;

import tv.codely.mooc.video.domain.Video;

public class LogVideoMother {

    public static LogVideo random() {
        var title = LogVideoTitleMother.random();
        var description = LogVideoDescriptionMother.random();
        return new LogVideo(title, description);
    }

    public static LogVideo createFrom(Video video) {
        return new LogVideo(
                new LogVideoTitle(video.title().value()),
                new LogVideoDescription(video.description().value())
        );
    }
}