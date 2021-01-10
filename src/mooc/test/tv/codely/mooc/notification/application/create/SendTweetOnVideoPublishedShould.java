package tv.codely.mooc.notification.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.errors.domain.ErrorGenerated;
import tv.codely.mooc.notification.domain.TwitterException;
import tv.codely.mooc.notification.domain.TwitterPublisher;
import tv.codely.mooc.video.domain.VideoPublished;
import tv.codely.shared.domain.EventBus;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

class SendTweetOnVideoPublishedShould {

    SendTweetOnVideoPublished sendTweetOnVideoPublished;

    TwitterPublisher publisher;
    EventBus eventBus;

    @BeforeEach
    void setUp() {
        publisher = mock(TwitterPublisher.class);
        eventBus = mock(EventBus.class);
        sendTweetOnVideoPublished = new SendTweetOnVideoPublished(publisher, eventBus);
    }

    @Test
    void consume_should_send_text_to_twitter() throws TwitterException {
        VideoPublished videoPublished = new VideoPublished("title", "description");

        sendTweetOnVideoPublished.consume(videoPublished);

        verify(publisher).tweet("New video published: " + videoPublished.title());
    }

    @Test
    void consume_should_send_notify_error_if_exception_tweeting() throws TwitterException {
        VideoPublished videoPublished = new VideoPublished("title", "description");
        TwitterException exception = new TwitterException("error", new IllegalArgumentException(""));
        doThrow(exception).when(publisher).tweet(anyString());

        sendTweetOnVideoPublished.consume(videoPublished);

        verify(eventBus).publish(asList(new ErrorGenerated("Error tweeting after video published", exception)));
    }
}