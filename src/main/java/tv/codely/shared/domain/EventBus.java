package tv.codely.shared.domain;

public interface EventBus {
    void publish(DomainEvent event);
}
