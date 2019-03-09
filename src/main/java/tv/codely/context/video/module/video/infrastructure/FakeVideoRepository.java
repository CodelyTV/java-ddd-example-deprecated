package tv.codely.context.video.module.video.infrastructure;

import tv.codely.context.video.module.video.domain.Video;
import tv.codely.context.video.module.video.domain.VideoRepository;

public final class FakeVideoRepository implements VideoRepository {
    @Override
    public void save(Video video) {
    }
}
