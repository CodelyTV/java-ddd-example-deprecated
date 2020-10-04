package tv.codely.mooc.video.infrastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import tv.codely.mooc.video.application.publish.VideoPublisher;
import tv.codely.mooc.video.domain.*;
import tv.codely.mooc.video.domain.specification.VideoDescriptionLikeSpecification;
import tv.codely.mooc.video.infrastructure.persistence.InMemoryVideoPersistence;
import tv.codely.shared.domain.EventBus;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

final class InMemoryVideoPersistenceShould {

    VideoRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryVideoPersistence();
        List<Video> videos = Arrays.asList(
                Video.create(new VideoTitle("Alien"), new VideoDescription("Seven got off but eight went aboard")),
                Video.create(new VideoTitle("Memento"), new VideoDescription("egnever skees amuart niarb htiw nam A")),
                Video.create(new VideoTitle("Star Wars"), new VideoDescription("A long time ago in a galaxy far, far away")));
        videos.forEach(repository::save);
    }

    @Test
    void persistAnyVideo_that_isSaved() {
        Video video = Video.create(new VideoTitle("The Goonies"),
                new VideoDescription("A group children go in search of a hidden pirate treasure in the 80's"));
        repository.save(video);
        Assertions.assertTrue(repository.all().anyMatch(v -> v.equals(video)), "repository must contain the saved video");
    }

    @Test
    void retrieveFilledOptionalVideo_when_searchingByMatchingIdentity() {
        Optional<Video> theGoonies = repository.search(new VideoTitle("Alien"));
        Assertions.assertNotNull(theGoonies, "the optional should not be null");
        Assertions.assertTrue(theGoonies.isPresent(), "the optional should contain the searched video");
    }

    @Test
    void retrieveEmptyOptionalVideo_when_searchingByNonMatchingIdentity() {
        Optional<Video> bladeRunner = repository.search(new VideoTitle("Blade Runner"));
        Assertions.assertNotNull(bladeRunner, "the optional should not be null");
        Assertions.assertTrue(bladeRunner.isEmpty(), "the optional should be empty");
    }

    @Test
    void retrieveListOfVideos_that_matchGivenSpecification() {
        List<Video> videos = repository.matching(new VideoDescriptionLikeSpecification(new VideoDescription("galaxy")));
        Assertions.assertFalse(videos.isEmpty(), "videos should not be empty");
    }
}
