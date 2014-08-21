package jp.ac.chibafjb.teclabo.summer.Shigut;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;

public class TwiBot {

	Twitter twitter = null;

	public TwiBot(Configuration config) {

		twitter = new TwitterFactory(config).getInstance();
	}

	public void tweet(String text) throws TwitterException {

		twitter.updateStatus(text);
	}

	public void tweetLearn(String word) throws TwitterException {

		twitter.updateStatus(word + "を覚えたよ。");
	}
}
