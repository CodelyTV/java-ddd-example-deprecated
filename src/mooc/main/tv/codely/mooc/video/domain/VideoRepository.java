package tv.codely.mooc.video.domain;

import java.util.Optional;

public interface VideoRepository {

    void save (Video video);

    Optional<Video> getLastVideo();

}
