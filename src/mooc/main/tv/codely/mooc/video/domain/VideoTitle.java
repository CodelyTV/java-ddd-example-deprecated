package tv.codely.mooc.video.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public final class VideoTitle {
    private final String value;

    public VideoTitle(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoTitle that = (VideoTitle) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
