package tv.codely.mooc.video.domain;

import lombok.Builder;
import lombok.Data;
import tv.codely.shared.domain.AggregateRoot;

@Builder
@Data
public final class Video extends AggregateRoot {
    private final VideoTitle title;
    private final VideoDescription description;

    private Video(VideoTitle title, VideoDescription description) {
        this.title = title;
        this.description = description;
    }

    public static Video publish(VideoTitle title, VideoDescription description) {
        var video = new Video(title, description);

        var videoCreated = new VideoPublished(title.value(), description.value());

        video.record(videoCreated);

        return video;
    }
}
