package tv.codely.mooc.video.domain;

import tv.codely.shared.domain.AggregateRoot;

public final class Video extends AggregateRoot {
    private final VideoTitle title;
    private final VideoDescription description;

    private Video(VideoTitle title, VideoDescription description) {
        this.title = title;
        this.description = description;
    }

    public static Video build(VideoTitle title, VideoDescription description){
        return new Video(title, description);
    }

    public static Video publish(VideoTitle title, VideoDescription description) {
        var video = new Video(title, description);

        var videoCreated = new VideoPublished(title.value(), description.value());

        video.record(videoCreated);

        return video;
    }

    public VideoTitle title() {
        return title;
    }

    public VideoDescription description() {
        return description;
    }
}
