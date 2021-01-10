package tv.codely.mooc.errors.infrastructure;

import tv.codely.mooc.errors.domain.ErrorGenerated;
import tv.codely.mooc.errors.domain.ErrorProcessor;

public class ErrorProcessorSystemErr implements ErrorProcessor {
    @Override
    public void processError(ErrorGenerated error) {
        System.err.println(error.getErrorMessage() + ":" + error.getCause());
    }
}
