package tv.codely.shared.infrastructure;

import tv.codely.shared.application.DomainEventSubscriber;
import tv.codely.shared.domain.DomainEvent;

public abstract class UnitTest {
    protected <T extends DomainEvent> void notify(T domainEvent, DomainEventSubscriber<T> domainEventSubscriber) {
        domainEventSubscriber.consume(domainEvent);
    }
}
