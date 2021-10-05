package tv.codely.mooc.notification.infrastructure;

import tv.codely.mooc.notification.domain.Notifier;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class LogNotifier implements Notifier {
	private final static Logger logger = Logger.getLogger(LogNotifier.class.getName());

	public LogNotifier(String fileName) throws FileHandlerCantBeCreated {
		try {
			FileHandler fileHandler = new FileHandler(fileName, true);
			logger.addHandler(fileHandler);
		} catch (IOException e) {
			throw new FileHandlerCantBeCreated(fileName);
		}
	}

	@Override
	public void notify(String text) {
		logger.info(text);
	}
}

