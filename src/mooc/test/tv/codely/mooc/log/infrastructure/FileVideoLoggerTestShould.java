package tv.codely.mooc.log.infrastructure;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.log.domain.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class FileVideoLoggerTestShould extends FileLogInfrastructureTest {

    private static final String LOG_FILE = "logs/app.log";
    private VideoLogger fileVideoLogger;

    @BeforeAll
    static void clean() throws IOException {
        final var logs = new File(LOG_FILE);
        if (!logs.exists()) {
            return;
        }
        FileUtils.forceDelete(logs);
    }

    @BeforeEach
    void setUp() {
        fileVideoLogger = new FileVideoLogger();
    }

    @AfterEach
    void tearDown() throws IOException {
        cleanAndReconfigureLogging(fileVideoLogger.getClass(), new File(LOG_FILE));
    }

    @Test
    void log() throws IOException {
        final var logVideo = LogVideoMother.random();
        final var publishedLogAction = new LogAction("published");

        fileVideoLogger.log(logVideo, publishedLogAction);

        FileLogVideo expectedFileLogVideo = FileLogVideo.create(logVideo, publishedLogAction);
        assertThat(getFileLogVideoFromLog()).usingRecursiveComparison()
                .isEqualTo(expectedFileLogVideo);
    }

    private FileLogVideo getFileLogVideoFromLog() throws IOException {
        var mapper = new ObjectMapper();
        Map<String, ?> log = mapper.readValue(new File(LOG_FILE), new TypeReference<>() {
        });
        mapper.addMixIn(FileLogVideo.class, FileLogVideoMixin.class);
        mapper.addMixIn(LoggedVideo.class, LoggedVideoMixin.class);
        return mapper.convertValue(log.get("message"), FileLogVideo.class);
    }
}