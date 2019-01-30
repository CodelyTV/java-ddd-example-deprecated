package tv.codely.shared.domain;

public interface EventBus {
    void notify(DomainEvent event);
}
