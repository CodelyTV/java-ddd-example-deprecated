package tv.codely.shared.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public interface DomainEvent {
    String fullQualifiedEventName();
    UUID domainEventId();
    LocalDateTime occurredOn();

    UUID aggregateId();
}
