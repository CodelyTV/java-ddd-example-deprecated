package tv.codely.mooc.notification.infrastructure;

import lombok.AllArgsConstructor;
import tv.codely.mooc.notification.domain.TwitterPublisher;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@AllArgsConstructor
public class Twitter4JPublisher implements TwitterPublisher {

    String consumerKey;
    String consumerSecret;
    String accessToken;
    String accessTokenSecret;

    protected Twitter getTwitterInstance() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }

    @Override
    public void tweet(String text) {
        try {
            getTwitterInstance().updateStatus(text);
        } catch (TwitterException e) {
            //TODO: To implement how to deal with these kind of errors.
        }
    }
}
