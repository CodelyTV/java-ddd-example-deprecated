package tv.codely.mooc.video.infrastructure;

import lombok.Getter;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VideoRepositoryInMemory implements VideoRepository {

    @Getter
    private List<Video> videos = new ArrayList<>();

    @Override
    public void save(Video video) {
        videos.add(video);
    }

    @Override
    public Optional<Video> getLastVideo() {
        if (videos.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(videos.get(videos.size() - 1));
        }
    }

}
