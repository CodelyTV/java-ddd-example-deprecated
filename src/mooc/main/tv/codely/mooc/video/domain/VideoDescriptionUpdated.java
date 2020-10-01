package tv.codely.mooc.video.domain;

import tv.codely.shared.domain.DomainEvent;

public final class VideoDescriptionUpdated implements DomainEvent {
    private static final String FULL_QUALIFIED_EVENT_NAME = "codelytv.video.video.event.1.video.description.updated";

    private final String title;
    private final String description;

    public VideoDescriptionUpdated(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String fullQualifiedEventName() {
        return FULL_QUALIFIED_EVENT_NAME;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoDescriptionUpdated that = (VideoDescriptionUpdated) o;

        if (!title.equals(that.title)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
