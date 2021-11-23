package tv.codely.mooc.twitter.infrastructure;

import tv.codely.mooc.twitter.application.TwiterRequest;
import tv.codely.mooc.twitter.domain.TwitterRepository;

/**
 * TODO: Implement a HTTPClient for the consume of the twitter API.
 */
public final class Twitter implements TwitterRepository {

    @Override
    public void create(TwiterRequest twit) {
        System.out.println(twit.getText());
    }
}
