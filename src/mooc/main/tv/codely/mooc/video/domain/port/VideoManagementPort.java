package tv.codely.mooc.video.domain.port;

import tv.codely.mooc.video.domain.Video;

public interface VideoManagementPort {

    void publish(final Video video);

}
