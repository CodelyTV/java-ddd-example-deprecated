package tv.codely.mooc.notification.application.create;

import tv.codely.mooc.video.domain.VideoPublished;
import tv.codely.shared.application.DomainEventSubscriber;

public class SendPushToSubscribersOnVideoPublished implements DomainEventSubscriber<VideoPublished> {
    @Override
    public Class<VideoPublished> subscribedTo() {
        return VideoPublished.class;
    }

    @Override
    public void consume(VideoPublished event) {
        System.out.println(
            String.format(
                "Hey! There is a new video with title <%s> and description <%s>",
                event.getTitle(),
                event.getDescription()
            )
        );
    }
}
