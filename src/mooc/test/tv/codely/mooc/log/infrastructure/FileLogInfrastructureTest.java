package tv.codely.mooc.log.infrastructure;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LifeCycle;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;

import java.io.File;
import java.io.IOException;

abstract class FileLogInfrastructureTest {

    protected void cleanAndReconfigureLogging(Class<?> loggerClass, File logFile) throws IOException {
        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Logger logger = ctx.getLogger(loggerClass.getName());
        final var appenders = logger.getAppenders();
        appenders.values().forEach(LifeCycle::stop);
        FileUtils.forceDelete(logFile);
        ctx.reconfigure();
    }
}