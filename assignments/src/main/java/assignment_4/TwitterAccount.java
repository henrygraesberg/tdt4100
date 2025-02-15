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

  void follow(TwitterAccount account) {
    this.following.add(account);
  }

  void unfollow(TwitterAccount account) {
    this.following.remove(account);
  }

  boolean isFollowing(TwitterAccount account) {
    return this.following.contains(account);
  }

  boolean isFollowedBy(TwitterAccount account) {
    return account.isFollowing(this);
  }

  void tweet(String tweetContent) {
    this.tweets.add(new Tweet(this, tweetContent));
  }

  void retweet(Tweet tweet) {
    this.tweets.add(new Tweet(this, tweet));
  }

  Tweet getTweet(int i) {
    return this.tweets.get(this.tweets.size() - i);
  }

  int getTweetCount() {
    return this.tweets.size();
  }

  int getRetweetCount() {
    int retweetCount = 0;

    for (Tweet tweet : tweets) {
      retweetCount += tweet.getRetweetCount();
    }

    return retweetCount;
  }
}
