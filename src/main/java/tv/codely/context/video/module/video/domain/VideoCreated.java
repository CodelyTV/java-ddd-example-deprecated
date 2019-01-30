package tv.codely.context.video.module.video.domain;

import tv.codely.shared.domain.DomainEvent;

public class VideoCreated implements DomainEvent {
    public static final String NAME = "video.created";

    private final String name;
    private final String description;

    public VideoCreated(String name, String description) {
        this.name        = name;
        this.description = description;
    }

    public String domainEventName() {
        return NAME;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }
}
