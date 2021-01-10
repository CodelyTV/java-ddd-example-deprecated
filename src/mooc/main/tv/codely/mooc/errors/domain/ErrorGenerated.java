package tv.codely.mooc.errors.domain;

import lombok.Value;
import tv.codely.shared.domain.DomainEvent;

@Value
public class ErrorGenerated implements DomainEvent {

    String errorMessage;
    Throwable cause;

    private static final String FULL_QUALIFIED_EVENT_NAME = "codelytv.errors.error.generated";

    @Override
    public String fullQualifiedEventName() {
        return FULL_QUALIFIED_EVENT_NAME;
    }
}
