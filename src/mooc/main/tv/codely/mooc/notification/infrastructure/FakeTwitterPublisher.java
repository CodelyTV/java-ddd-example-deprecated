package tv.codely.mooc.notification.infrastructure;

import tv.codely.mooc.notification.domain.TwitterPublisher;

public class FakeTwitterPublisher implements TwitterPublisher {
    @Override
    public void tweet(String text) {
        //Do nothing here
    }
}
