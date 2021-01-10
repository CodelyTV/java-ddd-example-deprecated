package tv.codely.mooc.notification.infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class Twitter4JPublisherShould {

    Twitter4JPublisher publisher;

    Twitter twitterInstance;

    @BeforeEach
    void setUp() {
        twitterInstance = mock(Twitter.class);
        publisher = spy(new Twitter4JPublisher("consumerKey", "consumerSecret", "accessToken", "accessTokenSecret"));
        doReturn(twitterInstance).when(publisher).getTwitterInstance();
    }

    @Test
    void post_tweet() throws tv.codely.mooc.notification.domain.TwitterException, TwitterException {
        String text = "Text to tweet";

        publisher.tweet(text);

        verify(twitterInstance).updateStatus(text);
    }

    @Test
    void post_tweet_with_error() throws TwitterException {
        String text = "Text to tweet";
        doThrow(new TwitterException("Error")).when(twitterInstance).updateStatus(text);

        assertThrows(tv.codely.mooc.notification.domain.TwitterException.class, () -> {
            publisher.tweet(text);
        });
    }

}