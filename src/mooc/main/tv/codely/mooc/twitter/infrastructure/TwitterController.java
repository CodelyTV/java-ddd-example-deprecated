package tv.codely.mooc.twitter.infrastructure;


import tv.codely.mooc.twitter.application.TwitterRequestDto;
import tv.codely.mooc.twitter.domain.TwitterRepository;

public class TwitterController implements TwitterRepository {

  @Override
  public void create(TwitterRequestDto twit) {
    System.out.println(twit.getText());
  }
}
