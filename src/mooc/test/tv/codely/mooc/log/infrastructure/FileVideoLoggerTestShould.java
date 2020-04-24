package tv.codely.mooc.log.infrastructure;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.log.domain.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class FileVideoLoggerTestShould {

    private VideoLogger fileVideoLogger;

    @BeforeEach
    void setUp() throws IOException {

        fileVideoLogger = new FileVideoLogger();
    }

    @AfterEach
    void tearDown() throws IOException {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Logger logger = ctx.getLogger("tv.codely.mooc.log.infrastructure");
        final FileAppender logToFile = (FileAppender) logger.getAppenders().get("LogToFile");
        logToFile.stop();
        FileUtils.forceDelete(new File("logs"));
    }

    @Test
    void log() throws IOException {
        final var logVideo = LogVideoMother.random();
        final var publishedLogAction = new LogAction("published");

        fileVideoLogger.log(logVideo, publishedLogAction);

        var mapper = new ObjectMapper();
        Map<String, ?> log = mapper.readValue(Paths.get("logs/app.log").toFile(), new TypeReference<>() {
        });
        mapper.addMixIn(FileLogVideo.class, FileLogVideoMixin.class);
        mapper.addMixIn(LoggedVideo.class, LoggedVideoMixin.class);
        var actualFileLogVideo = mapper.convertValue(log.get("message"), FileLogVideo.class);

        FileLogVideo expectedFileLogVideo = FileLogVideo.create(logVideo, publishedLogAction);
        assertThat(expectedFileLogVideo).usingRecursiveComparison()
                .isEqualTo(actualFileLogVideo);
    }
}