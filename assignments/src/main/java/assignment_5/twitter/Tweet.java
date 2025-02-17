package assignment_5.twitter;

public class Tweet {
  private TwitterAccount ownerAccount;
  private Tweet originalTweet;
  private String tweetContent;
  private int retweetCount;

  public Tweet(TwitterAccount tweetOwner, String tweetContent) {
    this.ownerAccount = tweetOwner;
    this.tweetContent = tweetContent;
  }
  public Tweet(TwitterAccount tweetOwner, Tweet originalTweet) {
    if(tweetOwner.equals(originalTweet.getOwner()))
      throw new IllegalArgumentException("You cannot retweet your own tweet");

    if(originalTweet.getOriginalTweet() != null)
      originalTweet = originalTweet.getOriginalTweet();
    
    this.ownerAccount = tweetOwner;
    this.originalTweet = originalTweet;

    originalTweet.incrementRetweetCount();
  }

  public String getText() {
    if(originalTweet != null) return originalTweet.getText();

    return this.tweetContent;
  }

  public TwitterAccount getOwner() {
    return this.ownerAccount;
  }

  public Tweet getOriginalTweet() {
    return originalTweet;
  }

  public int getRetweetCount() {
    return this.retweetCount;
  }

  public void incrementRetweetCount() {
    this.retweetCount++;
  }
}
