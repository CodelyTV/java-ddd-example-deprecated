package tv.codely.mooc.video.module.video.domain;

public final class VideoDescription {
    private final String value;

    public VideoDescription(final String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoDescription that = (VideoDescription) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
