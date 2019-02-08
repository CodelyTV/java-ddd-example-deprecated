package tv.codely.context.notification.module.push.application.send;

import tv.codely.context.video.module.video.domain.VideoPublished;
import tv.codely.shared.application.DomainEventSubscriber;

public class SendPushToSubscribersOnVideoPublished implements DomainEventSubscriber<VideoPublished> {
    @Override
    public Class<VideoPublished> subscribedTo() {
        return VideoPublished.class;
    }

    @Override
    public void consume(VideoPublished event) {
        // ToDo: Call AS
        
        System.out.println(
            String.format(
                "Hey! There is a new video with id <%s>, title <%s>, and description <%s>",
                event.aggregateId(),
                event.title(),
                event.description()
            )
        );
    }
}
