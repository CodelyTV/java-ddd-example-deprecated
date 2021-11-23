package tv.codely.mooc.twitter.infrastructure;

import tv.codely.mooc.twitter.domain.TwitterRepository;

public class Twitter implements TwitterRepository {

    @Override
    public void create(String text) {
        System.out.println(text);
    }
}
