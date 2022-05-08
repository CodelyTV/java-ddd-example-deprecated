package tv.codely.mooc.video.domain;

import lombok.Builder;
import lombok.Data;
import tv.codely.shared.domain.DomainEvent;

@Builder
@Data
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

}
