package tv.codely.mooc.twitter.domain;

import tv.codely.mooc.twitter.application.TwitterRequestDto;

public interface TwitterRepository {

    void create(TwitterRequestDto twit);

}
