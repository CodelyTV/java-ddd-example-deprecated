package tv.codely.mooc.log.domain;

public class LogVideo {
    private final LogVideoTitle title;
    private final LogVideoDescription description;

    public LogVideo(LogVideoTitle title, LogVideoDescription description) {
        this.title = title;
        this.description = description;
    }

    public LogVideoTitle title() {
        return title;
    }

    public LogVideoDescription description() {
        return description;
    }
}
