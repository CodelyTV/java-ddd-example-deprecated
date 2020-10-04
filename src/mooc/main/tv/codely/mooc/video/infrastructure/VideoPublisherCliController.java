package tv.codely.mooc.video.infrastructure;

import tv.codely.mooc.notification.application.create.SendPushToSubscribersOnVideoPublished;
import tv.codely.mooc.video.application.VideoResponse;
import tv.codely.mooc.video.application.find.VideoFinder;
import tv.codely.mooc.video.application.publish.VideoPublisher;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoDescription;
import tv.codely.mooc.video.domain.VideoTitle;
import tv.codely.mooc.video.domain.specification.VideoDescriptionLikeSpecification;
import tv.codely.mooc.video.infrastructure.persistence.InMemoryVideoPersistence;
import tv.codely.shared.application.DomainEventSubscriber;
import tv.codely.shared.domain.EventBus;
import tv.codely.shared.infrastructure.bus.ReactorEventBus;

import java.util.List;
import java.util.Set;

public class VideoPublisherCliController {
    public static void main(String[] args) {
        final Set<DomainEventSubscriber> subscribers = Set.of(
            new SendPushToSubscribersOnVideoPublished()
        );
        final EventBus eventBus = new ReactorEventBus(subscribers);
        final var videoPublisher = new VideoPublisher(eventBus);

        final var videoTitle = "\uD83C\uDF89 New YouTube.com/CodelyTV video title";
        final var videoDescription = "This should be the video description \uD83D\uDE42";

        videoPublisher.publish(videoTitle, videoDescription);

        InMemoryVideoPersistence repository = new InMemoryVideoPersistence();
        repository.save(Video.create(new VideoTitle("videoTitle1"), new VideoDescription("videoDescription1")));
        repository.save(Video.create(new VideoTitle("videoTitle2"), new VideoDescription("videoDescription2")));
        repository.save(Video.create(new VideoTitle("videoTitle3"), new VideoDescription("videoDescription3")));

        VideoFinder finder = new VideoFinder(repository);
        List<VideoResponse> videos = finder.findVideos(new VideoDescriptionLikeSpecification(new VideoDescription("description")));
        videos.forEach(System.out::println);
    }
}
