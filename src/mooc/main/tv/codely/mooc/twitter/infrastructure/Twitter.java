package tv.codely.mooc.twitter.infrastructure;

import tv.codely.mooc.twitter.application.TwitterRequest;
import tv.codely.mooc.twitter.domain.TwitterRepository;

/**
 * TODO: Implement a HTTPClient for the consume of the twitter API.
 */
public final class Twitter implements TwitterRepository {

    @Override
    public void create(TwitterRequest twit) {
        System.out.println(twit.getText());
    }
}
