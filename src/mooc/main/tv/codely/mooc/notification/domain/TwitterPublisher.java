package tv.codely.mooc.notification.domain;

public interface TwitterPublisher {

    void tweet (String text) throws TwitterException;
}
