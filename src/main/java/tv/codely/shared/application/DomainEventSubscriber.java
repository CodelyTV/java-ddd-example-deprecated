package tv.codely.shared.application;

import tv.codely.shared.domain.DomainEvent;

public interface DomainEventSubscriber<Event extends DomainEvent> {
    String subscribedTo();

    void react(Event event);
}
