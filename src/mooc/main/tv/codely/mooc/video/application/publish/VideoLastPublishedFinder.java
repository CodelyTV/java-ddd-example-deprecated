package tv.codely.mooc.video.application.publish;

import lombok.AllArgsConstructor;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoRepository;

import java.util.Optional;

@AllArgsConstructor
public final class VideoLastPublishedFinder {
    VideoRepository videoRepository;

    public Optional<Video> getLastVideoPublished() {
        return videoRepository.getLastVideo();
    }
}
