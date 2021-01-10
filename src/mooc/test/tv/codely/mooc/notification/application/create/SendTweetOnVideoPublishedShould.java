package tv.codely.mooc.notification.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.notification.domain.TwitterPublisher;
import tv.codely.mooc.video.domain.VideoPublished;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SendTweetOnVideoPublishedShould {

    SendTweetOnVideoPublished sendTweetOnVideoPublished;

    TwitterPublisher publisher;

    @BeforeEach
    void setUp() {
        publisher = mock(TwitterPublisher.class);
        sendTweetOnVideoPublished = new SendTweetOnVideoPublished(publisher);
    }

    @Test
    void consume_should_send_text_to_twitter() {
        VideoPublished videoPublished = new VideoPublished("title", "description");

        sendTweetOnVideoPublished.consume(videoPublished);

        verify(publisher).tweet("New video published: " + videoPublished.title());
    }
}