package tv.codely.mooc.errors.application;

import lombok.AllArgsConstructor;
import tv.codely.mooc.errors.domain.ErrorGenerated;
import tv.codely.mooc.errors.domain.ErrorProcessor;
import tv.codely.shared.application.DomainEventSubscriber;

@AllArgsConstructor
public class ProcessErrorGenerated implements DomainEventSubscriber<ErrorGenerated> {

    ErrorProcessor errorProcessor;

    @Override
    public Class<ErrorGenerated> subscribedTo() {
        return ErrorGenerated.class;
    }

    @Override
    public void consume(ErrorGenerated event) {
        errorProcessor.processError(event);
    }
}
