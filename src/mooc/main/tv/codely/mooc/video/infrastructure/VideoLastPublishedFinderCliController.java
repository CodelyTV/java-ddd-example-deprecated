package tv.codely.mooc.video.infrastructure;

import tv.codely.mooc.video.application.publish.VideoLastPublishedFinder;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoRepository;

import java.util.Optional;

public class VideoLastPublishedFinderCliController {
    public static void main(String[] args) {
        final VideoRepository videoRepository = new VideoRepositoryInMemory();
        final var videoLastPublishedFinder = new VideoLastPublishedFinder(videoRepository);

        Optional<Video> lastVideoPublished = videoLastPublishedFinder.getLastVideoPublished();
    }
}
