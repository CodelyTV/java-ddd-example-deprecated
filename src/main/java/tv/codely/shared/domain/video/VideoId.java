package tv.codely.shared.domain.video;

import java.util.UUID;

public final class VideoId {
    private final UUID value;

    public VideoId(final UUID value) {
        this.value = value;
    }

    public UUID value() {
        return value;
    }
}
