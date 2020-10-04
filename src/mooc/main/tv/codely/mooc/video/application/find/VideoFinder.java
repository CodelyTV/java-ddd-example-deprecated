package tv.codely.mooc.video.application.find;

import tv.codely.mooc.video.application.VideoResponse;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoRepository;
import tv.codely.shared.domain.Specification;

import java.util.List;
import java.util.stream.Collectors;

public final class VideoFinder {

    private final VideoRepository repository;

    public VideoFinder(VideoRepository repository) {
        this.repository = repository;
    }

    public List<VideoResponse> findVideos(Specification<Video> specification) {
        return repository.matching(specification).stream().map(this::toResponse).collect(Collectors.toList());
    }

    // TODO Extract mapper interface and add custom implementations
    private VideoResponse toResponse(Video videos) {
        return new VideoResponse(videos.getTitle().value(), videos.getDescription().value());
    }
}
