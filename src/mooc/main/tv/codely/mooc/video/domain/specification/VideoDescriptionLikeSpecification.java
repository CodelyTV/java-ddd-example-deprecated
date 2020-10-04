package tv.codely.mooc.video.domain.specification;

import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoDescription;
import tv.codely.shared.domain.Specification;

public final class VideoDescriptionLikeSpecification implements Specification<Video> {

    private final VideoDescription description;

    public VideoDescriptionLikeSpecification(VideoDescription description) {
        this.description = description;
    }

    @Override
    public boolean isSatisfied(Video video) {
        return containsIgnoreCase(video.getDescription().value(), description.value());
    }

    private boolean containsIgnoreCase(String str, String subString) {
        return str.toLowerCase().contains(subString.toLowerCase());
    }
}
