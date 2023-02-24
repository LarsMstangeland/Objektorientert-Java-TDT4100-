package oving4;

public class Tweet {

    private TwitterAccount Owner;
    private Tweet ReTweet;
    private boolean IsReTweet;
    private int numRT;
    private String Text;

    Tweet(TwitterAccount owner, String text) {
        this.Owner = owner;
        this.Text = text;
    }

    Tweet(TwitterAccount owner, Tweet tweet) {

        if (owner.equals(tweet.getOwner())) {
            throw new IllegalArgumentException("kan ikke rettweete egen tweet");
        }

        this.Owner = owner;
        this.Text = tweet.getText();

        tweet.AddNumberOfTimesRetweeted();
        this.ReTweet = tweet;
        this.IsReTweet = true;
    }

    public TwitterAccount getOwner() {
        return this.Owner;
    }

    public String getText() {
        return this.Text;
    }

    public Tweet getOriginalTweet() {

        if (IsReTweet) {
            return this.ReTweet;
        }
        return null;
    }

    public boolean IsReTweet() {
        return this.IsReTweet;
    }

    public void AddNumberOfTimesRetweeted() {
        this.numRT = this.numRT + 1;
    }

    public int getRetweetCount() {
        return this.numRT;
    }

    @Override
    public String toString() {
        return "Tweet [Owner=" + Owner + ", ReTweet=" + ReTweet + ", IsReTweet=" + IsReTweet + ", numRT=" + numRT
                + ", Text=" + Text + "]";
    }

    public static void main(String[] args) {

        TwitterAccount larsTwitterKonto = new TwitterAccount("lars");
        TwitterAccount sindreTwitterKonto = new TwitterAccount("sindre");

        Tweet forsteTweet = new Tweet(larsTwitterKonto, "hei, dette er føste tweet");
        Tweet RetweetAvForsteTweet = new Tweet(sindreTwitterKonto, forsteTweet);

        System.out.println(forsteTweet.getText());
        System.out.println(forsteTweet.getOwner());
        System.out.println(forsteTweet.getOriginalTweet());
        System.out.println(forsteTweet.getRetweetCount());

        System.out.println("--------------------------");

        System.out.println(RetweetAvForsteTweet.getText());
        System.out.println(RetweetAvForsteTweet.getOwner());
        System.out.println(RetweetAvForsteTweet.getOriginalTweet());
        System.out.println(RetweetAvForsteTweet.getRetweetCount());

    }

}
