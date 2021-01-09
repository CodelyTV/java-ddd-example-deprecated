package tv.codely.mooc.video.infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoDescription;
import tv.codely.mooc.video.domain.VideoTitle;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class VideoRepositoryInMemoryShould {

    VideoRepositoryInMemory repository;

    @BeforeEach
    void setUp() {
        repository = new VideoRepositoryInMemory();
    }

    @Test
    void save_should_persist_in_memory() {
        Video video = givenVideo("t", "d");

        repository.save(video);

        assertEquals(1, repository.getVideos().size());
        assertEquals(video, repository.getVideos().get(0));
    }

    private Video givenVideo(String title, String description) {
        return Video.publish(new VideoTitle(title), new VideoDescription(description));
    }

    @Test
    void get_last_should_not_receive_it_not_saved_any() {
        Optional<Video> lastVideoOpt = repository.getLastVideo();

        assertFalse(lastVideoOpt.isPresent());
    }

    @Test
    void get_last_should_receive_first_if_one_saved() {
        Video video = givenVideo("t", "d");
        repository.save(video);

        Optional<Video> lastVideoOpt = repository.getLastVideo();

        assertTrue(lastVideoOpt.isPresent());
        assertEquals(video, lastVideoOpt.get());
    }

    @Test
    void get_last_should_receive_first_if_more_than_one_saved() {
        Video video = givenVideo("t", "d");
        repository.save(video);
        Video video2 = givenVideo("t2", "d2");
        repository.save(video2);

        Optional<Video> lastVideoOpt = repository.getLastVideo();

        assertTrue(lastVideoOpt.isPresent());
        assertEquals(video2, lastVideoOpt.get());
    }

}