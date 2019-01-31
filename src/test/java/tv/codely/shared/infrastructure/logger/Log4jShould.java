package tv.codely.shared.infrastructure.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

final class Log4jShould {
    @Test
    void save_errors_in_the_log_file() {
        File errorsLogFile = new File("logs/codelytv-cqrs-ddd-java-example_errors.json");

        cleanErrorsLogFile(errorsLogFile);

        assertEquals(0, errorsLogFile.length());

        Logger logger = LogManager.getLogger(Log4jShould.class);

        RuntimeException exception = new RuntimeException("\uD83D\uDD25 Test exception");

        logger.error("Hello error world!", exception);

        assertNotEquals(0, errorsLogFile.length());
    }

    private void cleanErrorsLogFile(File errorsLogFile) {
        if (errorsLogFile.exists()) {
            errorsLogFile.delete();
        }

        try {
            errorsLogFile.createNewFile();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
