package tv.codely.mooc.log.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ObjectMessage;
import tv.codely.mooc.log.domain.LogAction;
import tv.codely.mooc.log.domain.LogVideo;
import tv.codely.mooc.log.domain.VideoLogger;

import java.util.Map;

public class FileVideoLogger implements VideoLogger {
    private static final Logger logger = LogManager.getLogger(FileVideoLogger.class);

    @Override
    public void log(LogVideo video, LogAction action) {
        final var fileLogVideo = FileLogVideo.create(video, action);
        ObjectMapper objectMapper = new ObjectMapper();
        logger.info(new ObjectMessage(objectMapper.convertValue(fileLogVideo, Map.class)));
    }
}
