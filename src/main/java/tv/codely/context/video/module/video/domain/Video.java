package tv.codely.context.video.module.video.domain;

import tv.codely.shared.domain.AggregateRoot;

public final class Video extends AggregateRoot {
    private final String title;
    private final String description;

    private Video(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public static Video publish(String title, String description) {
        var video = new Video(title, description);

        var videoCreated = new VideoPublished(title, description);

        video.record(videoCreated);

        return video;
    }
}
