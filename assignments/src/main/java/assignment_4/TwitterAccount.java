package assignment_4;

import java.util.ArrayList;

public class TwitterAccount {
  private String userName;
  private ArrayList<TwitterAccount> following = new ArrayList<TwitterAccount>();
  private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

  public TwitterAccount(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return this.userName;
  }

  public void follow(TwitterAccount account) {
    this.following.add(account);
  }

  public void unfollow(TwitterAccount account) {
    this.following.remove(account);
  }

  public boolean isFollowing(TwitterAccount account) {
    return this.following.contains(account);
  }

  public boolean isFollowedBy(TwitterAccount account) {
    return account.isFollowing(this);
  }

  public void tweet(String tweetContent) {
    this.tweets.add(new Tweet(this, tweetContent));
  }

  public void retweet(Tweet tweet) {
    this.tweets.add(new Tweet(this, tweet));
  }

  public Tweet getTweet(int i) {
    return this.tweets.get(this.tweets.size() - i);
  }

  public int getTweetCount() {
    return this.tweets.size();
  }

  public int getRetweetCount() {
    int retweetCount = 0;

    for (Tweet tweet : tweets) {
      retweetCount += tweet.getRetweetCount();
    }

    return retweetCount;
  }
}
