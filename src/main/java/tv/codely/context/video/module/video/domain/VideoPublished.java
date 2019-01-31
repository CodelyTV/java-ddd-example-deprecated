package tv.codely.context.video.module.video.domain;

import tv.codely.shared.domain.DomainEvent;

public final class VideoPublished implements DomainEvent {
    private static final String FULL_QUALIFIED_EVENT_NAME = "codelytv.video.video.event.1.video.published";

    private final String title;
    private final String description;

    public VideoPublished(String title, String description) {
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
}
