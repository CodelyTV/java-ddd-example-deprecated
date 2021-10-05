package tv.codely.mooc.notification.infrastructure;

public class FileHandlerCantBeCreated extends RuntimeException {
	FileHandlerCantBeCreated(String reason) {
		super("Can't create file handler:\n" + reason);
	}
}
