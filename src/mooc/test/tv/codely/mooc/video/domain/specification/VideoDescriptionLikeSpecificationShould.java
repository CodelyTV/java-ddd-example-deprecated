package tv.codely.mooc.video.domain.specification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoDescription;
import tv.codely.mooc.video.domain.VideoTitle;

public class VideoDescriptionLikeSpecificationShould {

    @Test
    void beSatisfied_When_GivenVideoContainsSpecifiedVideoTitle() {
        Video video = Video.create(new VideoTitle("The Karate Kid"),
                new VideoDescription("A bunch of kids get into trouble because of a bad karate teacher misapplying principles"));

        VideoDescriptionLikeSpecification specification = new VideoDescriptionLikeSpecification(new VideoDescription("karate"));

        Assertions.assertTrue(specification.isSatisfied(video), "specification should be satisfied");
    }

    @Test
    void notBeSatisfied_When_GivenVideoDoesNotContainSpecifiedVideoTitle() {
        Video video = Video.create(new VideoTitle("Jurassic Park"),
                new VideoDescription("Lovely scientist goes mad bringing dinosaurs back to life from fossilized mosquito"));

        VideoDescriptionLikeSpecification specification = new VideoDescriptionLikeSpecification(new VideoDescription("aliens"));

        Assertions.assertFalse(specification.isSatisfied(video), "specification should not be satisfied");
    }
}
