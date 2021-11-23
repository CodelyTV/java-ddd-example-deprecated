package tv.codely.mooc.twitter.domain;

import tv.codely.mooc.twitter.application.TwiterRequest;

public interface TwitterRepository {
    void create(TwiterRequest twit);
}
