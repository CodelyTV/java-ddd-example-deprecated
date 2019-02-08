package tv.codely.context.video.module.video.domain;

import tv.codely.shared.domain.DomainEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public final class VideoPublished implements DomainEvent {
    private static final String FULL_QUALIFIED_EVENT_NAME = "codelytv.video.video.event.video.published.1";

    private final UUID domainEventId;
    private final LocalDateTime occurredOn;

    private final UUID id;
    private final String title;
    private final String description;

    public VideoPublished(UUID id, String title, String description) {
        this.domainEventId = UUID.randomUUID();
        this.occurredOn = LocalDateTime.now();

        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public String fullQualifiedEventName() {
        return FULL_QUALIFIED_EVENT_NAME;
    }

    @Override
    public UUID domainEventId() {
        return domainEventId;
    }

    @Override
    public LocalDateTime occurredOn() {
        return occurredOn;
    }

    @Override
    public UUID aggregateId() {
        return id;
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

        VideoPublished that = (VideoPublished) o;

        if (!domainEventId.equals(that.domainEventId)) return false;
        if (!occurredOn.equals(that.occurredOn)) return false;
        if (!id.equals(that.id)) return false;
        if (!title.equals(that.title)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = domainEventId.hashCode();
        result = 31 * result + occurredOn.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
