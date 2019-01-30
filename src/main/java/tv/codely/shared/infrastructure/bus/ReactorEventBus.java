package tv.codely.shared.infrastructure.bus;

import reactor.bus.Event;
import reactor.bus.EventBus;
import tv.codely.shared.application.DomainEventSubscriber;
import tv.codely.shared.domain.DomainEvent;

import java.util.List;

import static reactor.bus.selector.Selectors.$;

public class ReactorEventBus implements tv.codely.shared.domain.EventBus {
    private final EventBus bus;

    public ReactorEventBus(List<DomainEventSubscriber> subscribers) {
        this.bus = EventBus.create();

        for (DomainEventSubscriber subscriber : subscribers)
        {
            this.bus.on(
                $(subscriber.subscribedTo()),
                reactorEvent -> subscriber.react((DomainEvent) reactorEvent.getData())
            );
        }
    }

    @Override
    public void notify(DomainEvent event) {
        this.bus.notify(event.domainEventName(), Event.wrap(event));
    }
}
