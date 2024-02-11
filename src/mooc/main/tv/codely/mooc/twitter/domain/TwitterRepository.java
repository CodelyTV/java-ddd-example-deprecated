package tv.codely.mooc.twitter.domain;

import tv.codely.mooc.twitter.application.TwitterRequest;

public interface TwitterRepository {
    void create(TwitterRequest twit);
}
