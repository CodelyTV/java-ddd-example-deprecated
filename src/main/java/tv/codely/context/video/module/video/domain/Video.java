package tv.codely.context.video.module.video.domain;

import tv.codely.shared.domain.AggregateRoot;
import tv.codely.shared.domain.video.VideoId;

public final class Video extends AggregateRoot {
    private final VideoId id;
    private final VideoTitle title;
    private final VideoDescription description;

    public Video(VideoId id, VideoTitle title, VideoDescription description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public static Video publish(VideoId id, VideoTitle title, VideoDescription description) {
        var video = new Video(id, title, description);

        var videoCreated = new VideoPublished(id.value(), title.value(), description.value());

        video.record(videoCreated);

        return video;
    }
}
