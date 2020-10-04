package tv.codely.mooc.video.application.find;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tv.codely.mooc.video.application.VideoResponse;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoDescription;
import tv.codely.mooc.video.domain.VideoRepository;
import tv.codely.mooc.video.domain.VideoTitle;
import tv.codely.mooc.video.domain.specification.VideoDescriptionLikeSpecification;
import tv.codely.shared.domain.Specification;

import java.util.Arrays;
import java.util.List;

public class VideoFinderShould {

    @Test
    void returnAListOfVideoResponses_When_GivenSpecificationMatchesSomePersistedData() {
        VideoRepository repository = Mockito.mock(VideoRepository.class);

        List<Video> videos = Arrays.asList(
                Video.create(new VideoTitle("Alien"), new VideoDescription("Seven got off but eight went aboard")),
                Video.create(new VideoTitle("Memento"), new VideoDescription("egnever skees amuart niarb htiw nam A")),
                Video.create(new VideoTitle("Star Wars"), new VideoDescription("A long time ago in a galaxy far, far away")));
        Mockito.when(repository.matching(Mockito.any())).thenReturn(videos);

        VideoFinder videoFinder = new VideoFinder(repository);
        List<VideoResponse> videoResponses = videoFinder.findVideos(new VideoDescriptionLikeSpecification(new VideoDescription("")));

        Assertions.assertNotNull(videoResponses, "videoResponses should not be null");
        Assertions.assertFalse(videoResponses.isEmpty(), "videoResponses should not be empty");
    }
}
