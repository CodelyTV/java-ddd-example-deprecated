package tv.codely.mooc.video.infrastructure.persistence;

import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoRepository;
import tv.codely.mooc.video.domain.VideoTitle;
import tv.codely.shared.domain.Identity;
import tv.codely.shared.domain.Specification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemoryVideoPersistence implements VideoRepository {

    private final Map<VideoTitle, Video> videos = new HashMap<>();

    @Override
    public void save(Video video) {
        videos.put(video.getTitle(), video);
    }

    @Override
    public Optional<Video> search(Identity<?> title) {
        return Optional.ofNullable(videos.get(title));
    }

    @Override
    public List<Video> matching(Specification<Video> specification) {
        return videos.values().stream().filter(specification::isSatisfied).collect(Collectors.toList());
    }

    @Override
    public Stream<Video> all() {
        return videos.values().stream();
    }
}
