package tv.codely.mooc.twitter.application;

import tv.codely.mooc.twitter.domain.TwitterRepository;
import tv.codely.mooc.video.domain.VideoPublished;
import tv.codely.shared.application.DomainEventSubscriber;

public class SendNotificationTwitter implements DomainEventSubscriber<VideoPublished> {

  private TwitterRepository twitterAPI;

  public SendNotificationTwitter(TwitterRepository twitterAPI) {
    this.twitterAPI = twitterAPI;
  }

  @Override
  public Class<VideoPublished> subscribedTo() {
    return VideoPublished.class;
  }

  @Override
  public void consume(VideoPublished event) {
    TwitterRequestDto twit = new TwitterRequestDto(
        String.format("Hey! A new video is published: <%s>", event.title())
    );
    twitterAPI.create(twit);
  }
}
