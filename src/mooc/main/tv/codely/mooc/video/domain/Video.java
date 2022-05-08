package tv.codely.mooc.video.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tv.codely.shared.domain.AggregateRoot;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public final class Video extends AggregateRoot {
    private final VideoTitle title;
    private final VideoDescription description;

    public static Video publish(VideoTitle title, VideoDescription description) {
        var video = new Video(title, description);

        var videoCreated = new VideoPublished(title.getValue(), description.getValue());

        video.record(videoCreated);

        return video;
    }
}
