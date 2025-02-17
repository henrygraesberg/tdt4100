package assignment_5.twitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TwitterAccount {
  private String userName;
  private ArrayList<TwitterAccount> following = new ArrayList<TwitterAccount>(), followers = new ArrayList<TwitterAccount>();
  private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

  public TwitterAccount(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return this.userName;
  }

  public void follow(TwitterAccount account) {
    this.following.add(account);
    account.addFollower(this);
  }

  public void unfollow(TwitterAccount account) {
    this.following.remove(account);
    account.removeFollower(this);
  }

  public void addFollower(TwitterAccount account) {
    this.followers.add(account);
  }

  public void removeFollower(TwitterAccount account) {
    this.followers.remove(account);
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

  public List<TwitterAccount> getFollowers(Comparator<TwitterAccount> comparator) {
    if(comparator == null) return this.followers;

    List<TwitterAccount> followersSorted = new ArrayList<TwitterAccount>(this.followers);
    Collections.sort(followersSorted, comparator);

    return followersSorted;
  }

  public Tweet getTweet(int i) {
    return this.tweets.get(this.tweets.size() - i);
  }

  public int getFollowerCount() {
    return this.followers.size();
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
