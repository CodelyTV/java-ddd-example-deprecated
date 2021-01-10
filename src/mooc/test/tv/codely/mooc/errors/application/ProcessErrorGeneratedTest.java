package tv.codely.mooc.errors.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.errors.domain.ErrorGenerated;
import tv.codely.mooc.errors.domain.ErrorProcessor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ProcessErrorGeneratedTest {

    ProcessErrorGenerated processErrorGenerated;

    ErrorProcessor errorProcessor;

    @BeforeEach
    void setUp() {
        errorProcessor = mock(ErrorProcessor.class);
        processErrorGenerated = new ProcessErrorGenerated(errorProcessor);
    }

    @Test
    void consume() {
        ErrorGenerated errorEvent = new ErrorGenerated("error", new IllegalArgumentException(""));

        processErrorGenerated.consume(errorEvent);

        verify(errorProcessor).processError(errorEvent);
    }
}