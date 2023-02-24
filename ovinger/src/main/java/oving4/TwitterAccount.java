package oving4;

import java.util.ArrayList;
import java.util.List;

public class TwitterAccount {

    private String Username;

    private List<TwitterAccount> following = new ArrayList<TwitterAccount>();
    private List<Tweet> Tweets = new ArrayList<Tweet>();

    public TwitterAccount(String username) {
        this.Username = username;
    }

    public String getUserName() {
        return this.Username;
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
        return account.following.contains(this);
    }

    public void tweet(String tweet) {

        Tweet NewTweet = new Tweet(this, tweet);
        this.Tweets.add(0, NewTweet);
    }

    public void retweet(Tweet tweet) {

        if (tweet.getOriginalTweet() == null) {
            Tweet NewTweet = new Tweet(this, tweet);
            this.Tweets.add(0, NewTweet);

        } else {
            Tweet NewTweet = new Tweet(this, tweet.getOriginalTweet());
            this.Tweets.add(0, NewTweet);

        }
    }

    public Tweet getTweet(int i) {
        return this.Tweets.get(i - 1);
    }

    public int getTweetCount() {
        return this.Tweets.size();
    }

    public int getRetweetCount() {
        int numberOfRetweetsThisAccountHas = 0;

        for (Tweet tweet : this.Tweets) {

            if (tweet.getOriginalTweet() == null) {
                numberOfRetweetsThisAccountHas = numberOfRetweetsThisAccountHas + tweet.getRetweetCount();
            }

        }

        return numberOfRetweetsThisAccountHas;
    }

    @Override
    public String toString() {

        return "" + this.Tweets;

    }

    public static void main(String[] args) {

        TwitterAccount larsTwitterKonto = new TwitterAccount("lars");
        TwitterAccount sindreTwitterKonto = new TwitterAccount("sindre");
        TwitterAccount perTwitterKonto = new TwitterAccount("per");

        larsTwitterKonto.tweet("forsteTweet");
        sindreTwitterKonto.retweet(larsTwitterKonto.getTweet(1));
        perTwitterKonto.retweet(sindreTwitterKonto.getTweet(1));

        System.out.println(sindreTwitterKonto.getTweetCount());
        System.out.println(sindreTwitterKonto.getRetweetCount());

        System.out.println("-----------------------");

        System.out.println(larsTwitterKonto.getTweetCount());
        System.out.println(larsTwitterKonto.getRetweetCount());

    }

}
