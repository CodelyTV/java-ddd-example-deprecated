package tv.codely.shared.infrastructure.bus;

import reactor.bus.Event;
import reactor.bus.EventBus;
import reactor.bus.selector.Selector;
import reactor.fn.Consumer;
import tv.codely.shared.application.DomainEventSubscriber;
import tv.codely.shared.domain.DomainEvent;

import java.util.Set;

import static reactor.bus.selector.Selectors.$;

public class ReactorEventBus implements tv.codely.shared.domain.EventBus {
    private final EventBus bus;

    public ReactorEventBus(final Set<DomainEventSubscriber> subscribers) {
        bus = EventBus.create();

        subscribers.forEach(this::registerOnEventBus);
    }

    @Override
    public void publish(final DomainEvent event) {
        Class<? extends DomainEvent> eventIdentifier = event.getClass();
        Event<DomainEvent> wrappedEvent = Event.wrap(event);

        bus.notify(eventIdentifier, wrappedEvent);
    }

    private void registerOnEventBus(final DomainEventSubscriber subscriber) {
        final Selector eventIdentifier = $(subscriber.subscribedTo());

        bus.on(eventIdentifier, eventConsumer(subscriber));
    }

    private Consumer<Event> eventConsumer(final DomainEventSubscriber subscriber) {
        return (Event reactorEvent) -> {
            DomainEvent unwrappedEvent = (DomainEvent) reactorEvent.getData();
            subscriber.consume(unwrappedEvent);
        };
    }
}
