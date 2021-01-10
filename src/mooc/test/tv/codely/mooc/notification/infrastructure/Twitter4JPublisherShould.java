package tv.codely.mooc.notification.infrastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class Twitter4JPublisherShould {

    Twitter4JPublisher publisher;

    Twitter twitterInstance;

    @BeforeEach
    void setUp() {
        publisher = spy(new Twitter4JPublisher("consumerKey", "consumerSecret", "accessToken", "accessTokenSecret"));
        Twitter twitterInstance = mock(Twitter.class);
        doReturn(twitterInstance).when(publisher).getTwitterInstance();
    }

    @Test
    void post_tweet() throws TwitterException {
        String text = "Text to tweet";

        publisher.tweet(text);

        verify(twitterInstance).updateStatus(text);
    }

}