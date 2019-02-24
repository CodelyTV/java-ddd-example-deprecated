package tv.codely.mooc.shared.application;

import tv.codely.mooc.shared.domain.DomainEvent;

public interface DomainEventSubscriber<EventType extends DomainEvent> {
    Class<EventType> subscribedTo();

    void consume(EventType event);
}
