package tv.codely.shared.application;

import tv.codely.shared.domain.DomainEvent;

public interface DomainEventSubscriber<EventType extends DomainEvent> {
    Class<EventType> subscribedTo();

    void consume(EventType event);
}
