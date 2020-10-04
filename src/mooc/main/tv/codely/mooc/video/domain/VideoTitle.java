package tv.codely.mooc.video.domain;

import tv.codely.shared.domain.Identity;

public final class VideoTitle implements Identity<String> {
    private final String value;

    public VideoTitle(String value) {
        this.value = value;
    }

    @Override
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
