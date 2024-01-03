package tv.codely.mooc.twitter.application;

public class TwitterRequestDto {
  private String id;
  private String text;

  public TwitterRequestDto(String id, String text) {
    this.id = id;
    this.text = text;
  }

  public TwitterRequestDto(String text) {
    this.text = text;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
